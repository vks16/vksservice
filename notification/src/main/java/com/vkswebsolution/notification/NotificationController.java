package com.vkswebsolution.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
public record NotificationController(NotificationService service) {

    @PostMapping
    public ResponseEntity sendNotification(@RequestBody NotificationBody body){
        log.info("New notification... {}", body);
        service.sendNotification(body);

        return new ResponseEntity(HttpStatus.OK);
    }
}
