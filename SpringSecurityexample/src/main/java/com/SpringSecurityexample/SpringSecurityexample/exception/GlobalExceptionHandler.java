package com.SpringSecurityexample.SpringSecurityexample.exception;

import com.SpringSecurityexample.SpringSecurityexample.globalresponsehandeler.ResponseApi;
import io.jsonwebtoken.JwtException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseApi<ApiError>> ResourceNotFoundExceptionHandeler(ResourceNotFoundException exception){

        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new ResponseApi<>(apiError),HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseApi<ApiError>> ExceptionHandeler(Exception exception){

        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(new ResponseApi<>(apiError),HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ResponseApi<ApiError>> AuthenticationExceptionExceptionHandeler(AuthenticationException exception){

        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(new ResponseApi<>(apiError),HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ResponseApi<ApiError>> AuthenticationExceptionExceptionHandeler(JwtException exception){

        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(new ResponseApi<>(apiError),HttpStatus.UNAUTHORIZED);

    }

}
