package com.bank.secure.backend.transaction.dto;

import java.time.LocalDateTime;

public record TransferResponse(
        String transactionId,
        String status,
        String riskLevel,
        LocalDateTime processedAt
) {
}
