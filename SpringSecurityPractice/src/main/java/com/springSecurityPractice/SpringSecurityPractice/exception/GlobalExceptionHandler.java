package com.springSecurityPractice.SpringSecurityPractice.exception;

import com.springSecurityPractice.SpringSecurityPractice.responseHandler.ApiResponse;
import io.jsonwebtoken.JwtException;
import org.apache.coyote.Response;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException exception){

        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new ApiResponse(apiError),HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> ExceptionHandler(Exception exception){

        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(new ApiResponse(apiError),HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse> AuthenticationExceptionExceptionHandler(AuthenticationException exception){

        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(new ApiResponse(apiError),HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiResponse> JwtExceptionExceptionHandler(JwtException exception){

        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(new ApiResponse(apiError),HttpStatus.UNAUTHORIZED);

    }


}
