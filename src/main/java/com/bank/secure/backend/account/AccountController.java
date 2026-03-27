package com.bank.secure.backend.account;

import com.bank.secure.backend.account.dto.AccountSummaryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/summary/{customerId}")
    public ResponseEntity<AccountSummaryResponse> getSummary(@PathVariable String customerId) {
        return ResponseEntity.ok(accountService.getSummary(customerId));
    }
}
