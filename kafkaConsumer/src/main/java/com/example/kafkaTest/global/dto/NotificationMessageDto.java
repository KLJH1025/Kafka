package com.example.kafkaTest.global.dto;

public record NotificationMessageDto(
        String receiverAddress,
        String title,
        String body
) {
}
