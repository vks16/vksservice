package com.vkswebsolution.notification;

public record NotificationBody(
        String subject,
        String message,
        Long customerId
) {
}
