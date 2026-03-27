package com.bank.secure.backend.notification;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public String notifyCustomer(String transactionId, String status) {
        return "Notification queued for transaction " + transactionId + " with status " + status;
    }
}
