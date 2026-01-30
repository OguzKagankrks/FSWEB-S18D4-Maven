package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;

public class BurgerException extends BurgerErrorException {

    public BurgerException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
