package com.example.kafka_avro_demo.controller;

import com.example.kafka_avro_demo.DTO.OrderRequest;
import com.example.kafkaavrodemo.avro.OrderCreatedEvent;
import com.example.kafka_avro_demo.producer.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderProducer orderProducer;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {
        OrderCreatedEvent event = OrderCreatedEvent.newBuilder()
                .setOrderId(request.getOrderId())
                .setCustomerId(request.getCustomerId())
                .setTotalAmount(request.getTotalAmount())
                .setCreatedAt(System.currentTimeMillis())
                .build();

        orderProducer.sendOrder(event);
        return ResponseEntity.ok("Order event sent to Kafka");
    }
}
