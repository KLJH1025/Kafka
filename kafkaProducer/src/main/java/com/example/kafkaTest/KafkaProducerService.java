package com.example.kafkaTest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// KafkaProducerService
/* 바라보고 있는 kafka broker topic 메세지 발행 */
@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducerService {

    @Value("${topic.name1}")
    private String topicName;

    /* Kafka Template 을 이용해 Kafka Broker 전송 */

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendEmailMessageToKafka(String message) {
        System.out.printf("Producer Send Email Message : %s%n",message);
        this.kafkaTemplate.send("email",message);
    }

    public void sendAlarmMessageToKafka(String message) {
        System.out.printf("Producer Send Alarm Message : %s%n",message);
        this.kafkaTemplate.send("alarm",message);
    }
}