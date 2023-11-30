package com.mymicroservices.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
