package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.ExceptionHandlingGlobal;


import lombok.Getter;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class ApiError {

    private LocalDateTime timestamp;

    private String error;

    private HttpStatus httpStatus;

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(String error, HttpStatus httpStatus) {
        this();
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
