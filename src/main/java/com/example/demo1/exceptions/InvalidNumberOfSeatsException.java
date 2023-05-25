package com.example.demo1.exceptions;

public class InvalidNumberOfSeatsException extends RuntimeException {
    public InvalidNumberOfSeatsException() {
    }

    public InvalidNumberOfSeatsException(String message) {
        super(message);
    }
}
