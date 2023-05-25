package com.example.demo1.exceptions;

public class InvalidTicketPriceException extends RuntimeException {
    public InvalidTicketPriceException() {}

    public InvalidTicketPriceException(String message) {
        super(message);
    }
}
