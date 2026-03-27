package com.bank.secure.backend.auth;

import com.bank.secure.backend.auth.dto.LoginRequest;
import com.bank.secure.backend.auth.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public LoginResponse login(LoginRequest request) {
        String maskedUser = request.username().replaceAll("[^a-zA-Z0-9]", "");
        return new LoginResponse(
                "access-token-" + maskedUser,
                "refresh-token-" + maskedUser,
                "CUSTOMER"
        );
    }
}
