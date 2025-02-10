package com.StudentdatabaseAdvance.Studentdatabase.CustomAnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class customAnnotationLogic implements ConstraintValidator<CustomAnotationdeclare,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(s==null){
            return false;
         }

        List<String> gread = List.of("A","B","C","D");

        return gread.contains(s);
    }
}
