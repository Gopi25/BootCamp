package com.example.kafka_avro_demo.consumer;

import com.example.kafkaavrodemo.avro.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "orders", groupId = "order-consumer-group")
public class OrderConsumer {
    @KafkaHandler
    public void consume(OrderCreatedEvent order) {
        System.out.println("Received Order: " + order);
    }
}
