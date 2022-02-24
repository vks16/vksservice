package com.vkswebsolution.customer;

public record CustomerRegisterationRequest(String firstName,
        String lastName,
        String email,
        String mobileNo
) {
}
