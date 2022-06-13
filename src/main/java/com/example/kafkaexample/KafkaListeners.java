package com.example.kafkaexample;

import com.example.kafkaexample.model.EmployeeData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "test-topic-1", groupId = "dummy-group")
    void listener(EmployeeData data){
        System.out.println("Received data from topic : "+data);
    }
}
