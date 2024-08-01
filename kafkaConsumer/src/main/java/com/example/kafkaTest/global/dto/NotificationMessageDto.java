package com.example.kafkaTest.global.dto;

public record NotificationMessageDto(
        String receiverAddress,
        String title,
        String body
) {
    @Override
    public String toString() {
        return "receiverAddress=" + receiverAddress + ", title=" + title + ", body=" + body;
    }
}
