Prerequisite
JDK 11

Steps to run the application:

1) Run docker compose file

Command -> 
docker-compose up

2) Check whether all services are running or not 

Command ->
docker ps

3) Now add three postgres connectors using curl command:

curl --location --request POST 'localhost:8083/connectors' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "sink-usagePerGroup",
"config": {
"connector.class": "io.confluent.connect.jdbc.JdbcSinkConnector",

    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "key.converter.schema.registry.url": "http://schema-registry:8081",
    "value.converter": "io.confluent.connect.avro.AvroConverter",
    "value.converter.schema.registry.url": "http://schema-registry:8081",

    "connection.url": "jdbc:postgresql://postgres:5432/kafka-sink",
    "connection.user": "postgres",
    "insert.mode": "upsert",
    "auto.create": true,
    "auto.evolve": true,
    "topics": "usagePerGroup",
    "pk.mode": "record_key",
    "pk.fields":"CoffeeMachineIdGroupIdKey"
}
}'

curl --location --request POST 'localhost:8083/connectors' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "sink-coffeeInformation",
"config": {
"connector.class": "io.confluent.connect.jdbc.JdbcSinkConnector",

    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "key.converter.schema.registry.url": "http://schema-registry:8081",
    "value.converter": "io.confluent.connect.avro.AvroConverter",
    "value.converter.schema.registry.url": "http://schema-registry:8081",

    "connection.url": "jdbc:postgresql://postgres:5432/kafka-sink",
    "connection.user": "postgres",
    "insert.mode": "upsert",
    "auto.create": true,
    "auto.evolve": true,
    "topics": "coffeeInformation",
    "pk.mode": "record_key",
    "pk.fields":"timestamp"
}
}'

curl --location --request POST 'localhost:8083/connectors' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "sink-singleVsDouble",
"config": {
"connector.class": "io.confluent.connect.jdbc.JdbcSinkConnector",

    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "key.converter.schema.registry.url": "http://schema-registry:8081",
    "value.converter": "io.confluent.connect.avro.AvroConverter",
    "value.converter.schema.registry.url": "http://schema-registry:8081",

    "connection.url": "jdbc:postgresql://postgres:5432/kafka-sink",
    "connection.user": "postgres",
    "insert.mode": "upsert",
    "auto.create": true,
    "auto.evolve": true,
    "topics": "singleVsDouble",
    "pk.mode": "record_key",
    "pk.fields":"timestamp"
}
}'

4) Start test jar which produces data to devices,coffees,coffeeMachines,customers topic

Command ->
/Library/Java/JavaVirtualMachines/jdk-11.0.15.jdk/Contents/Home/bin/java -jar kafka-stream-test.jar "http://localhost:8081" localhost:9092

5) Now run the spring boot application -> Run KafkaStreamApplication.java file
You will be able to see the logs in console, if consumers are working fine

6) Now login to postgres container and check the tables whether it is working fine or not

Command ->
docker exec -it <postgres-container-id> /bin/bash
psql -U postgres
\c kafka-sink
\dt+
select * from "public"."coffeeInformation";
select * from "public"."singleVsDouble";
select * from "public"."usagePerGroup";