package com.bank.secure.backend.auth;

import com.bank.secure.backend.auth.dto.LoginRequest;
import com.bank.secure.backend.auth.dto.LoginResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthServiceTest {

    private final AuthService authService = new AuthService();

    @Test
    void loginShouldSanitizeUsernameAndGenerateTokens() {
        LoginRequest request = new LoginRequest("user.name+1", "secret");

        LoginResponse response = authService.login(request);

        assertEquals("access-token-username1", response.accessToken());
        assertEquals("refresh-token-username1", response.refreshToken());
        assertEquals("CUSTOMER", response.role());
    }
}
