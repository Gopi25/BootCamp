package com.example.OrderEventsMongoDb.repository;

import com.example.OrderEventsMongoDb.model.OrderLifecycleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderLifecycleRepository  extends MongoRepository<OrderLifecycleDocument, String> {
    OrderLifecycleDocument findByOrderId(String orderId);
}
