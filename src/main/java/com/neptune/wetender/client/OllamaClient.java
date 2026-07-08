package com.neptune.wetender.client;

import com.neptune.wetender.dto.request.OllamaChatRequest;
import com.neptune.wetender.dto.response.OllamaChatResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class OllamaClient {

    private final RestClient ollamaRestClient;

    public OllamaClient(RestClient ollamaRestClient){
        this.ollamaRestClient = ollamaRestClient;
    }

    public OllamaChatResponse sendChatRequest(OllamaChatRequest request){
        return ollamaRestClient.post()
                        .uri("/chat")
                                .body(request)
                                        .retrieve()
                                                .body(OllamaChatResponse.class);
    }
}