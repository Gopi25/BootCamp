package com.example.OrderEventsMongoDb.controller;

import com.example.OrderEventsMongoDb.model.OrderLifecycleDocument;
import com.example.OrderEventsMongoDb.service.OrderLifecycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderLifecycleController {
    private final OrderLifecycleService service;

    @PostMapping("/{orderId}/events/{type}")
    public OrderLifecycleDocument addEvent(
            @PathVariable String orderId,
            @PathVariable String type,
            @RequestBody(required = false) Object payload) {
        return service.addEvent(orderId, type, payload);
    }

    @GetMapping("/{orderId}")
    public OrderLifecycleDocument getOrder(@PathVariable String orderId) {
        OrderLifecycleDocument doc = service.getOrder(orderId);
        if (doc == null) {
            throw new RuntimeException("Order not found: " + orderId);
        }
        return doc;
    }



}
