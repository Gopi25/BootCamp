package com.consumer.ConsumerService.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    //Listener for the order created topic
    @KafkaListener(topics ="order.created",groupId="my-consumer-group")
    public void consumeMsgFromTopic(String message){
        System.out.println("Received Message from order created topic:"+message);
    }

}
