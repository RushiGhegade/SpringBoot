package com.CollageManagementSystem.CollageManagementSystem.GlobalResponseSend;

import com.CollageManagementSystem.CollageManagementSystem.ExceptionHandling.ApiError;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ApiResponse<T> {

    LocalDateTime localDateTime;
    T data;
    ApiError apiError;

    public ApiResponse() {
        localDateTime= LocalDateTime.now();
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
