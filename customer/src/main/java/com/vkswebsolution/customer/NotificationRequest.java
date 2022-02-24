package com.vkswebsolution.customer;

public record NotificationRequest(Long customerId, String subject,
                                  String message) {
}
