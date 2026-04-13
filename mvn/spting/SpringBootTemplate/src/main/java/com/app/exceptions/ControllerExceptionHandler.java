package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {UserNorFoundException.class})
    public ResponseEntity<?> handleNoResult(UserNorFoundException ex) {
        return new ResponseEntity(ErrorObject.builder()
            .code("001")
            .message(ex.getMessage())
            .field("id")
            .build(), HttpStatus.BAD_REQUEST);
    }

}
