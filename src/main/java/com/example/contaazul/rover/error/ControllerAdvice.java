package com.example.contaazul.rover.error;

import com.example.contaazul.rover.error.exception.InvalidPositionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Void> handleValidationException(HandlerMethodValidationException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPositionException.class)
    public ResponseEntity<Void> handleInvalidPositionException(InvalidPositionException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleError(Exception ex) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
