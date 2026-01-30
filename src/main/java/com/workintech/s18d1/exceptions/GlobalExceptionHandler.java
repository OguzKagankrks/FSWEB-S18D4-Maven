package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BurgerException.class)
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException ex) {
        log.error("BurgerException: status={}, message={}", ex.getHttpStatus(), ex.getMessage(), ex);

        BurgerErrorResponse errorResponse = new BurgerErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleException(Exception ex) {
        log.error("Unhandled Exception: {}", ex.getMessage(), ex);

        BurgerErrorResponse errorResponse = new BurgerErrorResponse("Internal Server Error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
