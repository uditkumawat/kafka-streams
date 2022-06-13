package com.project.kafkastream;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import iot.Coffee;
import iot.CoffeeMachine;
import iot.Customer;
import iot.Device;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.joda.time.DateTime;

import java.time.Instant;
import java.util.Properties;

public class KafkaAvroProducer {

    public static void main(String args[]){

        Properties props = new Properties();
        props.setProperty("bootstrap.servers","localhost:9092");
        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        props.setProperty("schema.registry.url","http://localhost:8081");


        KafkaProducer<String, Coffee> coffeeProducer = new KafkaProducer<String, Coffee>(props);
        KafkaProducer<String, Device> deviceProducer = new KafkaProducer<String, Device>(props);
        KafkaProducer<String, CoffeeMachine> coffeeMachineProducer = new KafkaProducer<String, CoffeeMachine>(props);
        KafkaProducer<String, Customer> customerProducer = new KafkaProducer<String, Customer>(props);

        Device device = Device.newBuilder()
                .setId("1")
                .setSerial("ABCD-device")
                .setLatitude(76)
                .setLongitude(26)
                .setCoffeeMachineId("1")
                .build();

        CoffeeMachine coffeeMachine = CoffeeMachine.newBuilder()
                .setId("1")
                .setSerial("EFGH-coffeeMachine")
                .setCustomerId("1")
                .setGroupCount(1)
                .build();

        Coffee coffee = Coffee.newBuilder()
                .setId("1")
                .setTimestamp(new DateTime())
                .setGroupId(1)
                .setCoffeeMachineId("1")
                .setCustomerId("1")
                .setMilligrams(1)
                .setDosage(1)
                .build();

        Customer customer = Customer.newBuilder()
                .setId("1")
                .setName("Andreas")
                .setLongitude(26.90)
                .setLatitude(75.00)
                .build();

        ProducerRecord<String, Coffee> coffeeProducerRecord = new ProducerRecord<>("coffees",coffee.getId(),coffee);
        ProducerRecord<String,Device> deviceProducerRecord = new ProducerRecord<>("devices",device.getId(),device);
        ProducerRecord<String,CoffeeMachine> coffeeMachineProducerRecord = new ProducerRecord<>("coffeeMachines",coffeeMachine.getId(),coffeeMachine);
        ProducerRecord<String,Customer> customerProducerRecord = new ProducerRecord<>("customers",customer.getId(),customer);


        deviceProducer.send(deviceProducerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                System.out.println(recordMetadata.toString());
                System.out.println(e);
            }
        });

        coffeeProducer.send(coffeeProducerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                System.out.println(recordMetadata.toString());
                System.out.println(e);
            }
        });

        coffeeMachineProducer.send(coffeeMachineProducerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                System.out.println(recordMetadata.toString());
                System.out.println(e);
            }
        });

        customerProducer.send(customerProducerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {

                System.out.println(recordMetadata.toString());
                System.out.println(e);

                if(e!=null){
                    System.out.println(e.getStackTrace());
                    e.printStackTrace();
                }
            }
        });
    }
}
