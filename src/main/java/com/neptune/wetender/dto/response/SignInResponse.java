package com.neptune.wetender.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SignInResponse {
    private String id;

    private String userName;

    private String email;

    // Sign in message
    private String message;

    private LocalDateTime signInTime;
}
