package com.neptune.wetender.dto;

import lombok.Data;

@Data
public class OllamaChatRequest {
    private String model;
    private String message;
}
