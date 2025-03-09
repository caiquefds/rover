package com.example.contaazul.rover.error.exception;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String errorMessage) {
        super(errorMessage);
    }
}
