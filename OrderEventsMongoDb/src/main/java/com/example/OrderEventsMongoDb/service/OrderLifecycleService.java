package com.example.OrderEventsMongoDb.service;

import com.example.OrderEventsMongoDb.model.OrderLifecycleDocument;
import com.example.OrderEventsMongoDb.repository.OrderLifecycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderLifecycleService {
    private final OrderLifecycleRepository repository;

    public OrderLifecycleDocument addEvent(String orderId, String type, Object payload) {
        OrderLifecycleDocument doc = repository.findByOrderId(orderId);
        if (doc == null) {
            doc = new OrderLifecycleDocument();
            doc.setOrderId(orderId);
            doc.setEvents(new ArrayList<>());
        }

        OrderLifecycleDocument.OrderEvent event = new OrderLifecycleDocument.OrderEvent();
        event.setType(type);
        event.setTimestamp(Instant.now());
        event.setPayload(payload);

        doc.getEvents().add(event);
        return repository.save(doc);
    }

    public OrderLifecycleDocument getOrder(String orderId) {
        return repository.findByOrderId(orderId);
    }
}
