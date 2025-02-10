package com.springBoot.rushi.week1introduction.introductionToSpringBoot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public class Apple {

    void eatApple(){
        System.out.println("Bean is Running");
    }

    @PostConstruct
    void callBeforeIntialization(){
        System.out.println("Bean Is Initialize Sucessfully");
    }

    @PreDestroy
    void callBeforeDistroyed(){

        System.out.println("Bean Is Distroyed Sucessfully");
    }

}
