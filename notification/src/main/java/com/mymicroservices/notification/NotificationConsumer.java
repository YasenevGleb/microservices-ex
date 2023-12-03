package com.mymicroservices.notification;

import com.mymicroservices.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notification) {
        log.info("Consume {} from queue", notification);
        notificationService.sendNotification(notification);
    }
}
