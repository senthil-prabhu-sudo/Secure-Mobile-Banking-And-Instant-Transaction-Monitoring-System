package com.bank.secure.backend.monitoring;

import com.bank.secure.backend.monitoring.dto.RiskAssessmentResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionMonitoringService {

    public RiskAssessmentResponse assess(String transactionId, BigDecimal amount, String channel) {
        int score = amount.compareTo(new BigDecimal("5000")) > 0 ? 82 : 24;
        if ("INTERNATIONAL".equalsIgnoreCase(channel)) {
            score = Math.min(100, score + 10);
        }

        String level = score >= 80 ? "HIGH" : (score >= 50 ? "MEDIUM" : "LOW");
        boolean manualReview = score >= 80;

        return new RiskAssessmentResponse(transactionId, score, level, manualReview);
    }
}
