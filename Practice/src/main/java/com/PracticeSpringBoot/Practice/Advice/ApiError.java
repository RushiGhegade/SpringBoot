package com.PracticeSpringBoot.Practice.Advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {

    private HttpStatus httpStatus;
    private String message;

}
