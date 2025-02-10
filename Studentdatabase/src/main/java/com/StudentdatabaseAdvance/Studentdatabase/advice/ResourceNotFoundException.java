package com.StudentdatabaseAdvance.Studentdatabase.advice;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
