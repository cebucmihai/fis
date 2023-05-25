package com.example.demo1.exceptions;

public class EventAlreadyExistException extends RuntimeException {
    public EventAlreadyExistException() {
    }

    public EventAlreadyExistException(String message) {
        super(message);
    }
}
