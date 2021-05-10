package com.SpringChallange.springchallange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyShoppingCartException extends Exception{
    public EmptyShoppingCartException(String message) {
        super(message);
    }
}
