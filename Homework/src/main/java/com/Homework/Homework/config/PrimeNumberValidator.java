package com.Homework.Homework.config;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<CheckPrimeNumber,Integer> {


    boolean checkPrimeNumber(int num){

        int count = 0;

        for(int i=1;i<=num;i++){
            if(num%i==0){
                count++;
            }
        }
        if(count==2){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println("----------------"+checkPrimeNumber(integer));

        if(integer==null) return false;



        return checkPrimeNumber(integer);

    }
}
