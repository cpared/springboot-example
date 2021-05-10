package com.SpringChallange.springchallange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughProductsException extends Exception {
    public NotEnoughProductsException(String message) {
        super(message);
    }
}
