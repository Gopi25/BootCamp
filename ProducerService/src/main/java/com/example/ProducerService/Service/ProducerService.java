package com.example.ProducerService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMsgToOrderCreatedTopic(String message) {
        kafkaTemplate.send("order.created", message);
    }
}
