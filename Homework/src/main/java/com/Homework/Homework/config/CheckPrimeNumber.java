package com.Homework.Homework.config;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Digits;

import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Repeatable(Digits.List.class)
@Constraint(
        validatedBy = {
                PrimeNumberValidator.class
        }
)
public @interface CheckPrimeNumber {
    String message() default "{The number must be a prime number.}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
