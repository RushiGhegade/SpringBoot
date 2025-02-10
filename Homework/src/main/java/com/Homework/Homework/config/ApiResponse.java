package com.Homework.Homework.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timestamp; // Renamed from localDateTime to timestamp for clarity
    private String message; // New field for custom messages
    private T data; // The actual response data
    private ApiError apiError; // Error details (if any)

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    // Constructor for success responses with data
    public ApiResponse(String message, T data) {
        this();
        this.message = message;
        this.data = data;
    }

    // Constructor for error responses
    public ApiResponse(String message, ApiError apiError) {
        this();
        this.message = message;
        this.apiError = apiError;
    }

    // Constructor for success responses without data (e.g., for simple messages)
    public ApiResponse(String message) {
        this();
        this.message = message;
    }
}