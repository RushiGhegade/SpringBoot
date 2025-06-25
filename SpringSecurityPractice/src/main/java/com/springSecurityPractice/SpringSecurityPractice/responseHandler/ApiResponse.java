package com.springSecurityPractice.SpringSecurityPractice.responseHandler;

import com.springSecurityPractice.SpringSecurityPractice.exception.ApiError;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private LocalDateTime localDateTime;

    private T data;

    private ApiError apiError;


    public ApiResponse() {
        this.localDateTime =LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}
