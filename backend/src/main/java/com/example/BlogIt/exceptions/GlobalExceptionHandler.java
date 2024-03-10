package com.example.BlogIt.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> handleCustomException(CustomException ex)
    {
        return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),ex.getTimestamp(),ex.getStatus(),ex.getStatus().value()),ex.getStatus());
    }
}
