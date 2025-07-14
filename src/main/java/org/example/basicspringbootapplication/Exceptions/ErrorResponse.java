package org.example.basicspringbootapplication.Exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Builder

public class ErrorResponse {
    private  int statusCode;
    private  String message;
    private  LocalDateTime timestamp;

    public ErrorResponse(int statusCode, String message, LocalDateTime timestamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }

}

