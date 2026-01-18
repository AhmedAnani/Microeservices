package com.example.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<String> NotFoundException(NotFound ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(Founded.class)
    public ResponseEntity<String> FoundException(Founded ex) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(ex.getMessage());
    }
}