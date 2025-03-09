package com.example.contaazul.rover.error.exception;

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String errorMessage) {
        super(errorMessage);
    }
}
