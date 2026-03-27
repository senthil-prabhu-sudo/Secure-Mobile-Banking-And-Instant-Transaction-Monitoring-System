package com.bank.secure.backend.account.dto;

import java.math.BigDecimal;

public record AccountSummaryResponse(
        String accountNumber,
        String accountType,
        BigDecimal availableBalance,
        String currency
) {
}
