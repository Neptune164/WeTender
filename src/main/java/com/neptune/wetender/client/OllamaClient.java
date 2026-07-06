package com.neptune.wetender.client;

import com.neptune.wetender.dto.request.OllamaChatRequest;
import com.neptune.wetender.dto.response.OllamaChatResponse;
import com.neptune.wetender.properties.OllamaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@Service
public class OllamaClient {

    private final RestClient ollamaRestClient;

    public OllamaClient(RestClient ollamaRestClient){
        this.ollamaRestClient = ollamaRestClient;
    }

    public OllamaChatResponse setResponse(OllamaChatRequest request){
        OllamaChatResponse response = ollamaRestClient.post()
                        .uri("/chat")
                                .body(request)
                                        .retrieve()
                                                .body(OllamaChatResponse.class);

        if (response == null || response.getMessage() == null) {
            throw new RuntimeException("Ollama response or message is null");

        }
        System.out.println(response.getMessage().getContent());
        return response;
    }
}
