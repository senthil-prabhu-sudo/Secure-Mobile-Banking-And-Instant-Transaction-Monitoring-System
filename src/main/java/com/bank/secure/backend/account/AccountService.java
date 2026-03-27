package com.bank.secure.backend.account;

import com.bank.secure.backend.account.dto.AccountSummaryResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    public AccountSummaryResponse getSummary(String customerId) {
        return new AccountSummaryResponse(
                "XXXXXX" + customerId.substring(Math.max(0, customerId.length() - 4)),
                "SAVINGS",
                new BigDecimal("125000.75"),
                "USD"
        );
    }
}
