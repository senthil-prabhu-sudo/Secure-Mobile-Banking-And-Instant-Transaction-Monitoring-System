package com.bank.secure.backend.account;

import com.bank.secure.backend.account.dto.AccountSummaryResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountServiceTest {

    private final AccountService accountService = new AccountService();

    @Test
    void getSummaryShouldMaskAccountNumberUsingLastFourCharacters() {
        AccountSummaryResponse response = accountService.getSummary("CUST123456");

        assertEquals("XXXXXX3456", response.accountNumber());
        assertEquals("SAVINGS", response.accountType());
        assertEquals("125000.75", response.availableBalance().toPlainString());
        assertEquals("USD", response.currency());
    }
}
