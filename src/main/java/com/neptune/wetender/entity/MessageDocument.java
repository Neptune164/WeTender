package com.neptune.wetender.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "messages")
public class MessageDocument {
    @Id
    private String id;
    private String userMessage;
    private String assistantMessage;
    private String model;
    private String thinking;
    private String createdAt;

    private String userId;
    private String conversationId;
}
