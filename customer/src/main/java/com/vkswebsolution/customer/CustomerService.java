package com.vkswebsolution.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {


    public void registerCustomer(CustomerRegisterationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .mobileNo(request.mobileNo())
                .build();

        //todo: check email is valid
        // todo: check email is not taken
        customerRepository.saveAndFlush(customer);
        //todo: check if fraudster
        var fraudCheckResponseresponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId()
        );

        if(fraudCheckResponseresponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }
        //todo: send notification
    }
}
