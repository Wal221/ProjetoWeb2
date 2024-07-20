package com.wingsupenglishacademy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class UserNotFoundException  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String ex){
        super(ex);
    }
}
