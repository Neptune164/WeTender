package com.neptune.wetender.dto.response;

import lombok.Data;

@Data
public class OllamaMessage {
    private String content;
    private String role;
    private String thinking;
}