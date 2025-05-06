package com.microservices.accounts.dto;

public record AccountsMsgDTO(Long accountNumber, String name, String email, String mobileNumber) {
}
