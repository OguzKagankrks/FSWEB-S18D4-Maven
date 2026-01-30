package com.workintech.s18d1.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BurgerErrorException extends RuntimeException {

    private final HttpStatus httpStatus;

    public BurgerErrorException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
