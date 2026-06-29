package com.neptune.wetender.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "users")
public class UserDocument {
    @Id
    private String _id;

    private String userName;

    private String email;
    // hash key-value pair
    private String pwdHash;

    private LocalDateTime createdAt;
}
