package com.StudentdatabaseAdvance.Studentdatabase.CustomAnotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Max;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {
                customAnnotationLogic.class
        }
)
public @interface CustomAnotationdeclare {

    String message() default "Student is having Only A|B|C|D Grade";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
