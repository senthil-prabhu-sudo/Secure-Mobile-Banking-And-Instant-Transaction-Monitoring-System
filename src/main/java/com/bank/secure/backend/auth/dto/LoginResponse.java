package com.bank.secure.backend.auth.dto;

public record LoginResponse(
        String accessToken,
        String refreshToken,
        String role
) {
}
