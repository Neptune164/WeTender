package com.neptune.wetender.controller;

import com.neptune.wetender.exception.EmailAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<?> handleEmailAlreadyExistsException(EmailAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
