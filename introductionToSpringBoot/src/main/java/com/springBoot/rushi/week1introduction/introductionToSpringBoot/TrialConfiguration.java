package com.springBoot.rushi.week1introduction.introductionToSpringBoot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//@Configuration
public class TrialConfiguration {

    TrialConfiguration(){
        System.out.println("In Trial Configration Constructor");
    }

    @Bean
    @Scope("prototype")
    Apple getApple(){
        System.out.println("Now Call is Going in Configuration");
        return new Apple();
    }

}
