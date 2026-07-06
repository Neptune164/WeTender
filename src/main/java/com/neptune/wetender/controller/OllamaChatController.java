package com.neptune.wetender.controller;

import com.neptune.wetender.client.OllamaClient;
import com.neptune.wetender.dto.request.OllamaChatRequest;
import com.neptune.wetender.dto.response.OllamaChatResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ollama")
public class OllamaChatController {
    @Resource
    private OllamaClient client;

    @PostMapping("/chat")
    public OllamaChatResponse getMessages(@RequestBody OllamaChatRequest request){
        return client.setResponse(request);
    }
}
