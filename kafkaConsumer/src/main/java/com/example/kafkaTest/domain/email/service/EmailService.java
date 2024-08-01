package com.example.kafkaTest.domain.email.service;

import com.example.kafkaTest.domain.email.EmailProperties;
import com.example.kafkaTest.global.application.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Slf4j
@Component
public class EmailService implements MessageSender {

    private final EmailProperties emailProps;
    private final JavaMailSenderImpl mailSender;

    public EmailService(EmailProperties emailProps) {
        this.emailProps = emailProps;
        mailSender = new JavaMailSenderImpl();
        setMailSender();
    }
    private void setMailSender() {
        mailSender.setHost(emailProps.getHost());
        mailSender.setPort(emailProps.getPort());
        mailSender.setUsername(emailProps.getUsername());
        mailSender.setPassword(emailProps.getPassword());

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", emailProps.getProtocol());
        properties.put("mail.smtp.auth", emailProps.getSmtpAuthEnable());

        properties.put("mail.smtp.starttls.enable", emailProps.getStarttlsEnable());
        properties.put("mail.debug", emailProps.getDebugEnable());
    }

    @Override
    @Async
    public void sendMessage(String receiverAddress, String title, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@chickenstock.com");
        message.setTo(receiverAddress);
        message.setSubject(title);
        message.setText(body);

        mailSender.send(message);
    }
}
