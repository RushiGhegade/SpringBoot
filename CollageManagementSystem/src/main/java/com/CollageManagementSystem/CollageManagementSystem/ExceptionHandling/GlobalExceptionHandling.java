package com.CollageManagementSystem.CollageManagementSystem.ExceptionHandling;

import com.CollageManagementSystem.CollageManagementSystem.GlobalResponseSend.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse> ExceptionHandel(NoSuchElementException e){
        ApiError apiError =new ApiError(HttpStatus.NOT_FOUND,"Id Is Not Present in Table");
        return new ResponseEntity<>(new ApiResponse(apiError),HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> exceptionHanding(Exception e){
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return new ResponseEntity<>(new ApiResponse(apiError),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse> exceptionHandel(NullPointerException e){
        ApiError apiError =new ApiError(HttpStatus.NOT_FOUND,e.getMessage());
        return new ResponseEntity<>(new ApiResponse(apiError),HttpStatus.NOT_FOUND);
    }

}
