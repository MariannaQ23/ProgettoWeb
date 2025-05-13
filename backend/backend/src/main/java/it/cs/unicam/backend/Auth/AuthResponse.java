package it.cs.unicam.backend.Auth;

import lombok.Getter;

public class AuthResponse {
    @Getter

    private String accessToken;
    @Getter

    private String refreshToken;
    @Getter

    private String message;

    public AuthResponse(String accessToken, String refreshToken, String message) {
        this.accessToken = accessToken;
        this.message = message;
        this.refreshToken = refreshToken;
    }


}
