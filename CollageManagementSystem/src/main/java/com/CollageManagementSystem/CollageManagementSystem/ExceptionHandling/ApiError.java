package com.CollageManagementSystem.CollageManagementSystem.ExceptionHandling;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

public class ApiError {

    HttpStatus httpStatus;
    String message;

    public ApiError() {
    }

    public ApiError(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
