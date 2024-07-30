package com.example.kafkaTest.domain.firebase.dto;

public record Message(
        String token,
        Notification notification
) {
}
