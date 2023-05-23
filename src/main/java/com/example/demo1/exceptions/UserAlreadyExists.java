package com.example.demo1.exceptions;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(){}
    public UserAlreadyExists(String message){
        super(message);
    }
}
