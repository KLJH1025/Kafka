package com.example.kafkaTest;

import com.example.kafkaTest.dto.NotificationMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/kafka")
@RestController
public class KafkaProducerController {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/email")
    public ResponseEntity<Void> sendEmailMessage(@RequestBody NotificationMessageDto messageDto) {
        this.kafkaProducerService.sendEmailMessageToKafka(messageDto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/alarm")
    public ResponseEntity<Void> sendAlarmMessage(@RequestParam NotificationMessageDto message) {
        this.kafkaProducerService.sendAlarmMessageToKafka(message);

        return ResponseEntity.ok().build();
    }
}
