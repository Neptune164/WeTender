package com.neptune.wetender.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SignUpResponse {
    private String id;

    private String userName;

    private String email;

    private LocalDateTime createdAt;

    private String message;
}
