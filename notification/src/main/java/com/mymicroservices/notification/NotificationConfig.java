package com.mymicroservices.notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchanges;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(this.internalExchanges);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(this.notificationQueue);
    }

    @Bean
    public Binding internalExchangeToNotificationQueueBinding(){
        return BindingBuilder.bind(notificationQueue()).to(topicExchange()).with(internalNotificationRoutingKey);
    }

    public String getInternalExchanges() {
        return internalExchanges;
    }

    public String getNotificationQueue() {
        return notificationQueue;
    }

    public String getInternalNotificationRoutingKey() {
        return internalNotificationRoutingKey;
    }
}
