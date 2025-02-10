package com.Homework.Homework.Advice;

import com.Homework.Homework.config.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalLevelExceptionHandel  {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handelException(NoSuchElementException e){
        return new ResponseEntity<>("Employee Not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handele(Exception e){
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
