package com.example.demo1.exceptions;

public class InsufficientSeats extends Exception {
    public InsufficientSeats() {}

    public InsufficientSeats(String message) {
        super(message);
    }
}
