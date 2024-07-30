package com.example.kafkaTest.domain.email.controller;

import com.example.kafkaTest.domain.email.service.EmailService;
import com.example.kafkaTest.global.dto.NotificationMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public void sendEmail(@RequestBody NotificationMessageDto messageDto) {
        emailService.sendMessage(messageDto.receiverAddress(), messageDto.title(), messageDto.body());
    }

}