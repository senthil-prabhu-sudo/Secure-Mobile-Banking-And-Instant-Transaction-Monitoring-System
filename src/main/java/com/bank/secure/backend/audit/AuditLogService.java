package com.bank.secure.backend.audit;

import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

    public String logEvent(String eventType, String details) {
        return "AUDIT_EVENT=" + eventType + ", DETAILS=" + details;
    }
}
