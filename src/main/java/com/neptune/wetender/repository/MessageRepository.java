package com.neptune.wetender.repository;

import com.neptune.wetender.entity.MessageDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MessageRepository extends MongoRepository<MessageDocument, String> {

}
