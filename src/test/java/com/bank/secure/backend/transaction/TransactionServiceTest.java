package com.bank.secure.backend.transaction;

import com.bank.secure.backend.audit.AuditLogService;
import com.bank.secure.backend.monitoring.TransactionMonitoringService;
import com.bank.secure.backend.monitoring.dto.RiskAssessmentResponse;
import com.bank.secure.backend.notification.NotificationService;
import com.bank.secure.backend.transaction.dto.TransferRequest;
import com.bank.secure.backend.transaction.dto.TransferResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TransactionServiceTest {

    @Test
    void transferShouldMarkPendingReviewForHighRiskTransactions() {
        TransactionMonitoringService monitoringService = mock(TransactionMonitoringService.class);
        NotificationService notificationService = mock(NotificationService.class);
        AuditLogService auditLogService = mock(AuditLogService.class);

        when(monitoringService.assess(any(), eq(new BigDecimal("7000")), eq("INTERNATIONAL")))
                .thenReturn(new RiskAssessmentResponse("ignored", 95, "HIGH", true));

        TransactionService transactionService = new TransactionService(monitoringService, notificationService, auditLogService);
        TransferRequest request = new TransferRequest("A1", "B2", new BigDecimal("7000"), "USD", "INTERNATIONAL");

        TransferResponse response = transactionService.transfer(request);

        assertNotNull(response.transactionId());
        assertEquals("PENDING_REVIEW", response.status());
        assertEquals("HIGH", response.riskLevel());
        assertNotNull(response.processedAt());

        verify(notificationService).notifyCustomer(response.transactionId(), "PENDING_REVIEW");
        verify(auditLogService).logEvent(eq("TRANSFER"), any());
    }
}
