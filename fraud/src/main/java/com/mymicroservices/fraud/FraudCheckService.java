package com.mymicroservices.fraud;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public record FraudCheckService(
    FraudHistoryRepository fraudHistoryRepository
) {
    public boolean isFraudulentCustomer(Integer customerId) {
        fraudHistoryRepository.save(FraudCheckHistory.builder().isFraudster(false).customerId(customerId).createdAt(
            LocalDateTime.now()).build());
        return false;
    }
}
