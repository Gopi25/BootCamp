package com.example.Orderservice.service;

import com.example.Orderservice.avro.OrderCreatedEvent;
import com.example.Orderservice.event.OrderEventDocument;
import com.example.Orderservice.event.OrderEventRepository;
import com.example.Orderservice.kafka.OrderProducer;
import com.example.Orderservice.model.Order;
import com.example.Orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;
    private final OrderEventRepository eventRepository;

    public Order placeOrder(Order order) {
        Order savedOrder = orderRepository.save(order);

        // Build Avro Event
        OrderCreatedEvent event = OrderCreatedEvent.newBuilder()
                .setOrderId(savedOrder.getId().toString())
                .setProduct(savedOrder.getProduct())
                .setQuantity(savedOrder.getQuantity())
                .setPrice(savedOrder.getPrice())
                .build();

        // Send to Kafka
        orderProducer.sendOrderCreatedEvent(event);

        // Persist to Mongo (Event Sourcing simulation)
        OrderEventDocument eventDoc = OrderEventDocument.builder()
                .orderId(savedOrder.getId().toString())
                .product(savedOrder.getProduct())
                .quantity(savedOrder.getQuantity())
                .price(savedOrder.getPrice())
                .eventType("ORDER_CREATED")
                .build();

        eventRepository.save(eventDoc);

        return savedOrder;
    }
}
