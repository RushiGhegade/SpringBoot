package com.PracticeSpringBoot.Practice.Config;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class passwordValidationLogic implements ConstraintValidator<CustomCheckPassword,String> {

    boolean validatePassword(String password){
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=!]).*$") && (password.length()>=10);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return validatePassword(s);

    }
}
