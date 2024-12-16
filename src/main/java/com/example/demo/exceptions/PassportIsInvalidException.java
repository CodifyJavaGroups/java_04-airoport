package com.example.demo.exceptions;

public class PassportIsInvalidException extends RuntimeException {
    public PassportIsInvalidException(String message) {
        super(message);
    }
}
