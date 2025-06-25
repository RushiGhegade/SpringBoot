package com.laibraryManagement.LaibraryManagementProject.exception_handling;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String msg){
        super(msg);
    }

}

