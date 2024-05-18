package com.GameApp.dto;

import java.util.UUID;

public class LoginResponse {
    private UUID userId;
    private String message;

    public LoginResponse(UUID userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    // Getters and setters

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
