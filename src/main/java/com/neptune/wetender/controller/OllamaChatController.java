package com.neptune.wetender.controller;

import com.neptune.wetender.dto.request.OllamaChatRequest;
import com.neptune.wetender.service.OllamaService;
import com.neptune.wetender.vo.ChatResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ollama")
public class OllamaChatController {
    @Resource
    private OllamaService service;

    @PostMapping("/chat")
    public ChatResponse getMessages(@RequestBody OllamaChatRequest request){
        return service.generateReply(request);
    }
}
