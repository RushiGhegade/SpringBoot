package com.StudentdatabaseAdvance.Studentdatabase;

import com.StudentdatabaseAdvance.Studentdatabase.advice.ApiError;
import lombok.Data;
import org.aspectj.apache.bcel.generic.Tag;

import java.time.LocalDate;

@Data
public class ApiResponse<T> {

    private LocalDate timestamp;
    private T data;
    private ApiError error;

    public ApiResponse(){
        timestamp = LocalDate.now();
    }

    public ApiResponse(T data){
        this();
        this.data=data;
    }

    public ApiResponse(ApiError apiError){
        this();
        this.error=apiError;
    }
}
