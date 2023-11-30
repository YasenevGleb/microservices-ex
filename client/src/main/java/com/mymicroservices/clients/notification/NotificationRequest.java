package com.mymicroservices.clients.notification;

public record NotificationRequest(String notificationMessage, String email, String sender, Integer customerId) {
}
