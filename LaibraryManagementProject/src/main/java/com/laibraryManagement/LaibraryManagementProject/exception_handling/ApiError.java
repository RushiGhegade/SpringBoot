package com.laibraryManagement.LaibraryManagementProject.exception_handling;

import org.springframework.http.HttpStatus;

public class ApiError {

    HttpStatus httpStatus;
    String error;

    public ApiError(HttpStatus httpStatus, String error) {
        this.httpStatus = httpStatus;
        this.error = error;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
