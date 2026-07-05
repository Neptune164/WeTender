package com.neptune.wetender.dto.request;

import lombok.Data;

@Data
public class OllamaChatRequest {
    private String model;
    private String message;
}
