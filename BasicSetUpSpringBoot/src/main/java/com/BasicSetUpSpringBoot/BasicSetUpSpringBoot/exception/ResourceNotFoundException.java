package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
