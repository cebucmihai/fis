package com.example.demo1.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){}
    public UserAlreadyExistsException(String message){
        super(message);
    }
}
