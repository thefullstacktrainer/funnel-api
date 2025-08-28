package com.example.funnel.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalid(InvalidInputException ex) {
        ErrorResponse err = new ErrorResponse("INVALID_INPUT", ex.getMessage());
        return ResponseEntity.badRequest().body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex) {
        ErrorResponse err = new ErrorResponse("INTERNAL_ERROR", ex.getMessage());
        return ResponseEntity.status(500).body(err);
    }
}
