package com.neptune.wetender.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.ollama")
public class OllamaProperties {
    private String baseUrl;
    private String apiKey;
}
