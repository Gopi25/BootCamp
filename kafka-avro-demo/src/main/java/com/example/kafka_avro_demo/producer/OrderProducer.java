package com.example.kafka_avro_demo.producer;

import com.example.kafkaavrodemo.avro.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void sendOrder(OrderCreatedEvent order) {
        kafkaTemplate.send("orders", order.getOrderId().toString(), order);
    }
}
