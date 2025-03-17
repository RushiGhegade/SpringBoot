package com.SpringSecurityexample.SpringSecurityexample.exception;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
