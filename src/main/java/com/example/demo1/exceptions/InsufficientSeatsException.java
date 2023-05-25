package com.example.demo1.exceptions;

public class InsufficientSeatsException extends Exception {
    public InsufficientSeatsException() {}

    public InsufficientSeatsException(String message) {
        super(message);
    }
}
