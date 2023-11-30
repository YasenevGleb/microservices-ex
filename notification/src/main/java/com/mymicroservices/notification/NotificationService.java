package com.mymicroservices.notification;

import com.mymicroservices.clients.notification.NotificationRequest;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository repository;

    public void sendNotification(NotificationRequest request) {
        repository.saveAndFlush(
            Notification.builder()
                .notificationMessage(request.notificationMessage())
                .toCustomerId(request.customerId())
                .toCustomerEmail(request.email())
                .sender("Gleb")
                .createdAt(LocalDateTime.now())
                .build());
    }
}
