package com.neptune.wetender.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OllamaChatResponse {
    private String model;

    @JsonProperty("created_at")
    private String createdAt;

    private OllamaMessage message;
    private Boolean done;
}
