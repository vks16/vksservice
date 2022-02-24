package com.vkswebsolution.fraud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
public record FraudController(
        FraudCheckService service
) {
    @GetMapping("/{customerId}")
    public ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") Long customerId) {
        return new ResponseEntity<>(new FraudCheckResponse(service.isFraudsterCustomer(customerId)), HttpStatus.OK);
    }

}
