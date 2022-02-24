package com.vkswebsolution.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
public record CustomerController(
        CustomerService customerService
) {

    @PostMapping
    public ResponseEntity registerCustomer(@RequestBody CustomerRegisterationRequest customer){
        log.info("New Customer Registeration {}", customer);
        customerService.registerCustomer(customer);

        return new ResponseEntity(HttpStatus.OK);
    }
}
