package com.example.Orderservice.event;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface OrderEventRepository extends MongoRepository<OrderEventDocument, String>{
}
