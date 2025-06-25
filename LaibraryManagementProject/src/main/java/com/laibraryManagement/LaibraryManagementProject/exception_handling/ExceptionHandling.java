package com.laibraryManagement.LaibraryManagementProject.exception_handling;

import com.laibraryManagement.LaibraryManagementProject.advice.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handelException1(Exception e){
        ApiResponse apiResponse = new ApiResponse(new ApiError(HttpStatus.NOT_FOUND,e.getMessage()));
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handelException(Exception e){

        ApiResponse apiResponse = new ApiResponse(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage()));

        return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
