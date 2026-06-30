package com.neptune.wetender.exception;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
