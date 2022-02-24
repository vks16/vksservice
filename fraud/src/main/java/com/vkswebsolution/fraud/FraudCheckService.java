package com.vkswebsolution.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckService(FraudCheckHistoryRepository repository) {

    public boolean isFraudsterCustomer(Long customerId) {
        boolean isFraud = false;
        var entity = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(isFraud)
                .createdAt(LocalDateTime.now())
                .build();
        repository.save(entity);
        return isFraud;
    }
}
