package com.neptune.wetender.service;

import com.neptune.wetender.client.OllamaClient;
import com.neptune.wetender.dto.request.OllamaChatRequest;
import com.neptune.wetender.dto.response.OllamaChatResponse;
import com.neptune.wetender.entity.MessageDocument;
import com.neptune.wetender.repository.MessageRepository;
import com.neptune.wetender.vo.ChatResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OllamaService {

    @Resource
    private OllamaClient ollamaClient;

    @Resource
    private MessageRepository messageRepository;

    public ChatResponse generateReply(OllamaChatRequest request){
        MessageDocument message = new MessageDocument();

        if(request == null ||
            request.getMessages() == null ||
            request.getModel() == null ||
            request.getMessages().isEmpty()) {
            throw new RuntimeException("The request is invalid.");
        }

        message.setUserMessage(request.getMessages().getFirst().getContent());
        message.setModel(request.getModel());

        OllamaChatResponse response = ollamaClient.sendChatRequest(request);
        if(response == null ||
                response.getMessage() == null ||
                response.getMessage().getContent() == null ||
                response.getCreatedAt() == null ||
                response.getModel() == null){
            throw new RuntimeException("The response is empty.");
        }

        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setMessage(response.getMessage().getContent());
        chatResponse.setModel(response.getModel());
        chatResponse.setThinking(response.getMessage().getThinking());
        chatResponse.setCreatedAt(response.getCreatedAt());

        message.setAssistantMessage(chatResponse.getMessage());
        message.setThinking(chatResponse.getThinking());
        message.setCreatedAt(chatResponse.getCreatedAt());
        messageRepository.save(message);

        return chatResponse;
    }
}
