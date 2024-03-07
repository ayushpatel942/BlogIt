package com.example.BlogIt.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse
{
    private String message;
    private LocalDateTime timestamp;
    private HttpStatus status;
    private int statuscode;
}
