package com.mymicroservices.customer;

public record CustomerRequest(
    String firstName,
    String lastName,
    String email) {
}
