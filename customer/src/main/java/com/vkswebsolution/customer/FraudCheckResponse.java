package com.vkswebsolution.customer;

import lombok.Builder;

@Builder
public record FraudCheckResponse(Boolean isFraudster) {
}
