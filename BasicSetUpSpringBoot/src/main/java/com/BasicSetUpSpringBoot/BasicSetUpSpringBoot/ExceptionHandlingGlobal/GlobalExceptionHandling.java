package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.ExceptionHandlingGlobal;

import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handelException(ResourceNotFoundException e){

        ApiError apiError = new ApiError(e.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);

    }

}
