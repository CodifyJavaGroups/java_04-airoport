package com.example.demo.exceptions;

public class RegisterUnsuccessException extends RuntimeException {
    public RegisterUnsuccessException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
