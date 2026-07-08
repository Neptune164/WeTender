package com.neptune.wetender.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatResponse {
    private String message;
    private String createdAt;
    private String model;
    private String thinking;
}
