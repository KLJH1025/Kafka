package com.example.kafkaTest.domain.firebase;

import com.example.kafkaTest.domain.firebase.application.FirebaseMessageSender;
import com.example.kafkaTest.global.dto.NotificationMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firebase")
@RequiredArgsConstructor
public class FirebaseController {
    private final FirebaseMessageSender messageSender;

    @PostMapping
    public ResponseEntity<?> messagingTest(@RequestBody NotificationMessageDto requestDto) {
        messageSender.sendMessage(requestDto.receiverAddress(), requestDto.title(), requestDto.body());
        return ResponseEntity.ok().build();
    }
}
