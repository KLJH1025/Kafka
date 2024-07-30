package com.example.kafkaTest;

import com.example.kafkaTest.domain.email.service.EmailService;
import com.example.kafkaTest.global.dto.NotificationMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final EmailService emailService;

    //groupId = "consumer_group01"
    @KafkaListener(topics = "email", groupId = "consumer_group01", containerFactory = "kafkaListenerContainerFactory")
    public void consumeEmailMessage(ConsumerRecord<String, NotificationMessageDto> messageDto) throws IOException {
        System.out.println("Success to reach Sender, Topic = Email");
        NotificationMessageDto nmd = messageDto.value();
        emailService.sendMessage(nmd.receiverAddress(), nmd.title(), nmd.body());
        System.out.printf("Consumed Received Email Message : %s%n", nmd);
    }

//    @KafkaListener(topics = "alarm", groupId = "consumer_group01")
//    public void consumeAlarmMessage(String message) throws IOException {
//        System.out.printf("Consumed Received Alarm Message : %s%n", message);
//    }

}