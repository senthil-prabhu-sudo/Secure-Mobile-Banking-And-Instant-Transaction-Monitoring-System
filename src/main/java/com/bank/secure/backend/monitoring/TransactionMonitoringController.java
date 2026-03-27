package com.bank.secure.backend.monitoring;

import com.bank.secure.backend.monitoring.dto.RiskAssessmentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/monitoring")
public class TransactionMonitoringController {

    private final TransactionMonitoringService monitoringService;

    public TransactionMonitoringController(TransactionMonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping("/risk")
    public ResponseEntity<RiskAssessmentResponse> assessRisk(
            @RequestParam String transactionId,
            @RequestParam BigDecimal amount,
            @RequestParam(defaultValue = "MOBILE") String channel
    ) {
        return ResponseEntity.ok(monitoringService.assess(transactionId, amount, channel));
    }
}
