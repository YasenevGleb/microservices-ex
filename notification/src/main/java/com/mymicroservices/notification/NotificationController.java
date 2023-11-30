package com.mymicroservices.notification;


import com.mymicroservices.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {
    private final NotificationService service;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request) {
        log.info("Created new request notification {}", request);
        service.sendNotification(request);
    }
}
