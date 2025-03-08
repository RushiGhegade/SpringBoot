package com.AllSpringSecurity.SpringSecurity.exception;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handelExceptionResourceNotFoundException(ResourceNotFoundException exception){
        return new ResponseEntity<>(new ApiError(exception.getMessage(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handelExceptionAuthenticationException(AuthenticationException exception){
        return new ResponseEntity<>(new ApiError(exception.getMessage(),HttpStatus.UNAUTHORIZED),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handelExceptionJwtException(JwtException exception){
        return new ResponseEntity<>(new ApiError(exception.getMessage(),HttpStatus.UNAUTHORIZED),HttpStatus.UNAUTHORIZED);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiError> handelExceptionException(Exception exception){
//        return new ResponseEntity<>(new ApiError(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
