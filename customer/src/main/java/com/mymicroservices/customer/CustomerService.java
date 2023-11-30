package com.mymicroservices.customer;

import com.mymicroservices.clients.fraud.FraudCheckResponse;
import com.mymicroservices.clients.fraud.FraudClient;
import com.mymicroservices.clients.notification.NotificationClient;
import com.mymicroservices.clients.notification.NotificationRequest;
import com.sun.jdi.InternalException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate,
                              FraudClient fraudClient, NotificationClient notificationClient) {
    public void registerCustomer(CustomerRequest request) {
        Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());
        if (response.isFraudster()) {
            throw new InternalException("fraudster");
        }
        notificationClient.sendNotification(
            new NotificationRequest("Test notification", customer.getEmail(), customer.getLastName(),
                customer.getId()));
    }
}
