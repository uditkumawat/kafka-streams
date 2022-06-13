package com.project.kafkastream;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

import iot.*;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import static org.apache.kafka.streams.kstream.Grouped.with;

@SpringBootApplication
public class KafkaStreamApplication {

    public static final String APPLICATION_NAME = "kafkaStreamProcessing";
    public static final String BOOTSTRAP_SERVERS = "localhost:9092";
    public static final String REPLICATION_FACTOR = "replication.factor";
    public static final String DEVICES_TOPIC = "devices";
    public static final String COFFEES_TOPIC = "coffees";
    public static final String COFFEEMACHINES_TOPIC = "coffeeMachines";
    public static final String CUSTOMERS_TOPIC = "customers";
    public static final String COFFEEINFORMATION_TOPIC = "coffeeInformation";
    public static final String SINGLE_VS_DOUBLE_TOPIC = "singleVsDouble";
    public static final String USAGE_PER_GROUP_TOPIC = "usagePerGroup";
    public static final String NOTIFICATION_TOPIC = "notification";
    public static final String SCHEMA_REGISTRY_URL_KEY = "schema.registry.url";
    public static final String SCHEMA_REGISTRY_URL_VALUE = "http://localhost:8081";


    public static void main(String[] args) {

        SpringApplication.run(KafkaStreamApplication.class, args);

        consume();
    }

    public static void consume() {

        StreamsBuilder  builder = new StreamsBuilder();

        Properties streamsConfiguration = new Properties();

        streamsConfiguration.put(
                StreamsConfig.APPLICATION_ID_CONFIG,
                APPLICATION_NAME);
        streamsConfiguration.put(
                StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        streamsConfiguration.put(
                StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,
                Serdes.String().getClass().getName());
        streamsConfiguration.put(
                StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,
                SpecificAvroSerde.class);
        streamsConfiguration.put(SCHEMA_REGISTRY_URL_KEY,SCHEMA_REGISTRY_URL_VALUE);
        streamsConfiguration.put(REPLICATION_FACTOR,1);

        final Map<String, String> serdeConfig = Collections.singletonMap(SCHEMA_REGISTRY_URL_KEY,SCHEMA_REGISTRY_URL_VALUE);

        final Serde<String> keySpecificAvroSerde = new SpecificAvroSerde();
        keySpecificAvroSerde.configure(serdeConfig, true);

        final Serde<Device> deviceValueSpecificAvroSerde = new SpecificAvroSerde();
        deviceValueSpecificAvroSerde.configure(serdeConfig, true);

        final Serde<Coffee> coffeeValueSpecificAvroSerde = new SpecificAvroSerde();
        coffeeValueSpecificAvroSerde.configure(serdeConfig, true);

        final Serde<CoffeeMachine> coffeeMachineValueSpecificAvroSerde = new SpecificAvroSerde();
        coffeeMachineValueSpecificAvroSerde.configure(serdeConfig, true);

        final Serde<Customer> customerValueSpecificAvroSerde = new SpecificAvroSerde();
        customerValueSpecificAvroSerde.configure(serdeConfig, true);

        KTable<String,Device> deviceTable = builder.table(DEVICES_TOPIC, Materialized.with(Serdes.String(),deviceValueSpecificAvroSerde));
        KStream<String,Coffee> coffeesData = builder.stream(COFFEES_TOPIC,Consumed.with(Serdes.String(),coffeeValueSpecificAvroSerde));
        KTable<String,CoffeeMachine> coffeeMachineTable = builder.table(COFFEEMACHINES_TOPIC,Materialized.with(Serdes.String(),coffeeMachineValueSpecificAvroSerde));
        KTable<String,Customer> customerDataTable = builder.table(CUSTOMERS_TOPIC,Materialized.with(Serdes.String(),customerValueSpecificAvroSerde));

        deviceTable.toStream().peek((key,value)->{
            System.out.println("deviceTable Data");
            System.out.println(key+" "+value);
        });

        coffeeMachineTable.toStream().peek((key,value)->{
            System.out.println("coffeeMachineTable Data");
            System.out.println(key+" "+value);
        });

        customerDataTable.toStream().peek((key,value)->{
            System.out.println("customerTable Data");
            System.out.println(key+" "+value);
        });

        ////combining device , coffeeMachine and customer table based on foreign key relationship as this data is fixed
        //starts
        KTable<String,Device> coffeeMachineIdKeyDeviceTable = deviceTable.toStream().map((k,v)->{
            return KeyValue.pair(v.getCoffeeMachineId(),v);
        }).toTable();


        KTable<String, CoffeeInformation> coffeeMachineJoinedDeviceTable = coffeeMachineTable.join(coffeeMachineIdKeyDeviceTable,(coffeeMachine, device)->{
            return CoffeeInformation.newBuilder()
                    .setCoffeeMachineSerial(coffeeMachine.getSerial())
                    .setDeviceSerial(device.getSerial())
                    .setCustomerId(coffeeMachine.getCustomerId())
                    .build();
        });

        KTable<String,CoffeeInformation> customerIdCoffeeMachineDeviceTable = coffeeMachineJoinedDeviceTable.toStream().map((k,v)->{
           return KeyValue.pair(v.getCustomerId(),v);
        }).toTable();

        KTable<String,Customer> customerIdCustomerTable = customerDataTable.toStream().map((k,v)->{
           return KeyValue.pair(v.getId(),v);
        }).toTable();

        KTable<String,CoffeeInformation> customerCoffeeMachineDeviceTable = customerIdCoffeeMachineDeviceTable.join(customerIdCustomerTable,(customerCoffeeDevice,customer)->{
            return CoffeeInformation.newBuilder()
                    .setCustomerId(customer.getId())
                    .setDeviceSerial(customerCoffeeDevice.getDeviceSerial())
                    .setCustomerName(customer.getName())
                    .setTimestamp(customerCoffeeDevice.getTimestamp())
                    .setCoffeeMachineSerial(customerCoffeeDevice.getCoffeeMachineSerial())
                    .build();
        });
        //ends

        //changing coffee stream to have join with customerCoffeeMachineDeviceTable
        KStream<String, Coffee> customerIdKeyCoffee = coffeesData.map((k,v)->{
            return KeyValue.pair(v.getCustomerId(),v);
        });

        KStream<String,CoffeeInformation> coffeeInformation = customerIdKeyCoffee.join(customerCoffeeMachineDeviceTable,(coffee, customerCoffeeMachineDevice) -> {
            return CoffeeInformation.newBuilder()
                    .setCoffeeId(coffee.getId())
                    .setCoffeeMachineSerial(customerCoffeeMachineDevice.getCoffeeMachineSerial())
                    .setCoffeeDosage(coffee.getDosage())
                    .setCoffeeMilligrams(coffee.getMilligrams())
                    .setTimestamp(coffee.getTimestamp().getMillis())
                    .setCustomerName(customerCoffeeMachineDevice.getCustomerName())
                    .setGroupId(coffee.getGroupId())
                    .setDeviceSerial(customerCoffeeMachineDevice.getDeviceSerial())
                    .setCustomerId(customerCoffeeMachineDevice.getCustomerId())
                    .build();
        });

        KStream<String,CoffeeInformation> updatedStream = coffeeInformation.map((k,v)->{
           return KeyValue.pair(v.getCoffeeId(),v);
        });

        updatedStream.peek((key,value)->{
            System.out.println("CoffeeInformation Data");
            System.out.println(key+" "+value);
        });

        //pushing data to topic, kafka connect will send it to respective tables
        updatedStream.to(COFFEEINFORMATION_TOPIC);


        //streaming based on single vs double dosage and sending to topic singleVsDouble
        KStream<String,SingleVsDouble> singleVsDoubleKStream = coffeeInformation.filter((k,v)->v.getCoffeeDosage()<3).map((k,v)->{
            SingleVsDouble singleVsDouble = SingleVsDouble.newBuilder()
                    .setCustomerId(v.getCustomerId())
                    .setDosage(v.getCoffeeDosage())
                    .build();
            return KeyValue.pair(v.getTimestamp().toString(),singleVsDouble);
        });

        singleVsDoubleKStream.peek((key,value)->{
            System.out.println("SingleVsDouble data");
            System.out.println(key+" "+value);
        });

        //pushing data to topic, kafka connect will send it to respective tables
        singleVsDoubleKStream.to(SINGLE_VS_DOUBLE_TOPIC);

        //Group usage
        KStream<String,UsagePerGroup> usagePerGroupStream = coffeesData.map((key, coffee) -> new KeyValue(coffee.getCoffeeMachineId()+","+coffee.getGroupId(),1))
                .groupByKey(with(Serdes.String(), Serdes.Integer()))
                .count()
                .toStream().map((key,value)->{
                    String tokens[] = key.toString().split(",");
                    String coffeeMachineId = tokens[0];
                    String groupId = tokens[1];

                    UsagePerGroup usagePerGroup = UsagePerGroup.newBuilder()
                            .setCoffeeMachineIdGroupIdKey(key.toString())
                            .setGroupId(groupId)
                            .setCoffeeMachineId(coffeeMachineId)
                            .setCount(Long.parseLong(value.toString()))
                            .build();

                   return KeyValue.pair(key,usagePerGroup);
                });

        usagePerGroupStream.peek((k,v)->{
           System.out.println("UsagePerGroup Data");
            System.out.println(k+" "+v);
        });

        //pushing data to topic, kafka connect will send it to respective tables
        usagePerGroupStream.to(USAGE_PER_GROUP_TOPIC);

        KTable<String, Notification> notificationTable = coffeeMachineTable.join(coffeeMachineIdKeyDeviceTable,(coffeeMachine, device)->{
            return Notification.newBuilder()
                    .setDeviceId(device.getId())
                    .setDeviceSerial(device.getSerial())
                    .setDeviceLatitude(device.getLatitude())
                    .setDeviceLongitude(device.getLongitude())
                    .setCoffeeMachineId(device.getCoffeeMachineId())
                    .setCoffeeMachineSerial(coffeeMachine.getSerial())
                    .setCustomerId(coffeeMachine.getCustomerId())
                    .setGroupCount(coffeeMachine.getGroupCount())
                    .build();
        });

        notificationTable.toStream().peek((k,v)->{
            System.out.println("coffeeMachineDeviceTable notification table");
            System.out.println(k+" "+v);
        });

        notificationTable.toStream().to(NOTIFICATION_TOPIC);

        Topology topology = builder.build();
        KafkaStreams streams = new KafkaStreams(topology,streamsConfiguration);
        streams.start();


    }

}
