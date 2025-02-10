package com.PracticeSpringBoot.Practice.Config;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {
                passwordValidationLogic.class
        }
)
public @interface CustomCheckPassword {
    String message() default "Contains One UpperCase Latter , One Lower Case Latter , one Special Character , minimum length 10";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
