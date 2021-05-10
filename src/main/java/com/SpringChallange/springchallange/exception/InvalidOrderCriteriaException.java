package com.SpringChallange.springchallange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOrderCriteriaException extends Exception{

    public InvalidOrderCriteriaException(String message) {
        super(message);
    }
}
