package com.example.kafkaTest.dto;

public record NotificationMessageDto(
        String receiverAddress,
        String title,
        String body
) {
}