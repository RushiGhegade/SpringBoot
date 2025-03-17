package com.SpringSecurityexample.SpringSecurityexample.globalresponsehandeler;


import com.SpringSecurityexample.SpringSecurityexample.exception.ApiError;

import java.time.LocalDateTime;

public class ResponseApi<T> {

    LocalDateTime localDateTime;
    T data;
    ApiError apiError;

    public ResponseApi() {
        this.localDateTime = LocalDateTime.now();
    }

    public ResponseApi(T data) {
        this();
        this.data = data;
    }

    public ResponseApi(ApiError apiError) {
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
