package com.PracticeSpringBoot.Practice.Advice;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse> nofound(NullPointerException e){
        ApiError apiError = ApiError.builder().message(e.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(new ApiResponse<>(apiError),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> HandelAll(Exception e){
        ApiError apiError = ApiError.builder().message(e.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(new ApiResponse<>(apiError),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handelInputValidation(MethodArgumentNotValidException e){

        List<String> error = e.getBindingResult().getAllErrors().stream().map(e1->e1.getDefaultMessage()).toList();

        ApiError  apiError = ApiError.builder().httpStatus(HttpStatus.BAD_REQUEST).message(error.toString()).build();
        return new ResponseEntity<>(new ApiResponse<>(apiError),HttpStatus.BAD_REQUEST);
    }

}
