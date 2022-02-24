package com.vkswebsolution.notification;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository repository) {
    public void sendNotification(NotificationBody body) {
        repository.save(Notification.builder()
                        .createdAt(LocalDateTime.now())
                        .subject(body.subject())
                        .message(body.message())
                        .customerId(body.customerId())
                .build());
    }
}
