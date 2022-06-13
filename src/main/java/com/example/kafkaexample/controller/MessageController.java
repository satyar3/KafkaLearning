package com.example.kafkaexample.controller;

import com.example.kafkaexample.model.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, EmployeeData> kafkaTemplate;

    @Autowired
    public MessageController(KafkaTemplate<String, EmployeeData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/postMessage")
    public void publish(@RequestBody EmployeeData employeeData){
        System.out.println("Message from REST Client is : "+ employeeData);
        kafkaTemplate.send("test-topic-1", employeeData);
    }
}
