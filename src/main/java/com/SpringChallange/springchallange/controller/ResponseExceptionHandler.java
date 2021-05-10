package com.SpringChallange.springchallange.controller;


import com.SpringChallange.springchallange.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EmptyShoppingCartException.class, ProductNotFoundException.class})
    public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request){
        ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), new Date(), request.getDescription(false));
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NotEnoughProductsException.class, InvalidOrderCriteriaException.class, ClientException.class})
    public final ResponseEntity<Object> handleBadRequestException(Exception ex, WebRequest request){
        ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), new Date(), request.getDescription(false));
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InternalServerException.class, NullPointerException.class})
    public final ResponseEntity<Object> handleInternalServerException(Exception ex, WebRequest request){
        ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), new Date(), request.getDescription(false));
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
