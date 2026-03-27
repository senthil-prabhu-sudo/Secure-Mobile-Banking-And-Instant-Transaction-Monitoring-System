package com.bank.secure.backend.monitoring;

import com.bank.secure.backend.monitoring.dto.RiskAssessmentResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionMonitoringServiceTest {

    private final TransactionMonitoringService service = new TransactionMonitoringService();

    @Test
    void assessShouldReturnHighRiskForLargeInternationalTransfer() {
        RiskAssessmentResponse response = service.assess("tx-1", new BigDecimal("6000"), "INTERNATIONAL");

        assertEquals(92, response.score());
        assertEquals("HIGH", response.riskLevel());
        assertTrue(response.requiresManualReview());
    }

    @Test
    void assessShouldReturnLowRiskForSmallDomesticTransfer() {
        RiskAssessmentResponse response = service.assess("tx-2", new BigDecimal("100"), "MOBILE");

        assertEquals(24, response.score());
        assertEquals("LOW", response.riskLevel());
        assertFalse(response.requiresManualReview());
    }
}
