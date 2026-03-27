package com.bank.secure.backend.monitoring.dto;

public record RiskAssessmentResponse(
        String transactionId,
        int score,
        String riskLevel,
        boolean requiresManualReview
) {
}
