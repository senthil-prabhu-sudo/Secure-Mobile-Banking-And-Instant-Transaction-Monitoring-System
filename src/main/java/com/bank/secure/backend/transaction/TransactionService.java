package com.bank.secure.backend.transaction;

import com.bank.secure.backend.audit.AuditLogService;
import com.bank.secure.backend.monitoring.TransactionMonitoringService;
import com.bank.secure.backend.monitoring.dto.RiskAssessmentResponse;
import com.bank.secure.backend.notification.NotificationService;
import com.bank.secure.backend.transaction.dto.TransferRequest;
import com.bank.secure.backend.transaction.dto.TransferResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionMonitoringService monitoringService;
    private final NotificationService notificationService;
    private final AuditLogService auditLogService;

    public TransactionService(
            TransactionMonitoringService monitoringService,
            NotificationService notificationService,
            AuditLogService auditLogService
    ) {
        this.monitoringService = monitoringService;
        this.notificationService = notificationService;
        this.auditLogService = auditLogService;
    }

    public TransferResponse transfer(TransferRequest request) {
        String transactionId = UUID.randomUUID().toString();
        RiskAssessmentResponse risk = monitoringService.assess(transactionId, request.amount(), request.channel());

        String status = risk.requiresManualReview() ? "PENDING_REVIEW" : "SUCCESS";
        notificationService.notifyCustomer(transactionId, status);
        auditLogService.logEvent("TRANSFER", "transactionId=" + transactionId + ",risk=" + risk.riskLevel());

        return new TransferResponse(transactionId, status, risk.riskLevel(), LocalDateTime.now());
    }
}
