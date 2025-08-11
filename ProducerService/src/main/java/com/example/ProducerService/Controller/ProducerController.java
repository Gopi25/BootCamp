package com.example.ProducerService.Controller;

import com.example.ProducerService.Service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProducerController {
    @Autowired
    ProducerService producerService;
    @PostMapping("/publish/order")
    public  String sendMessageToOrderCreatedTopic(@RequestBody String message){
        producerService.sendMsgToOrderCreatedTopic(message);
        return "Message sent successfully to the topic:"+message;
    }

}
