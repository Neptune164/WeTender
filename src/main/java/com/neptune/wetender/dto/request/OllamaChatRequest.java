package com.neptune.wetender.dto.request;

import com.neptune.wetender.dto.response.OllamaMessage;
import lombok.Data;

import java.util.List;

@Data
public class OllamaChatRequest {
    private String model;
    private List<OllamaMessage> messages;
    private Boolean stream = false;
}
