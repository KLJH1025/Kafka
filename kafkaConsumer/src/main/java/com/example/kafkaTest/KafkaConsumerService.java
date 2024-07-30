package com.example.kafkaTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "email", groupId = "consumer_group01")
    public void consumeEmailMessage(String message) throws IOException {
        System.out.printf("Consumed Received Email Message : %s%n", message);
    }

    @KafkaListener(topics = "alarm", groupId = "consumer_group01")
    public void consumeAlarmMessage(String message) throws IOException {
        System.out.printf("Consumed Received Alarm Message : %s%n", message);
    }
}