package com.SpringChallange.springchallange.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter @Setter
public class ExceptionResponse {
    private String message;
    private Date timestamp;
    private String details;

    public ExceptionResponse(String message, Date timestamp, String details) {
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }
}
