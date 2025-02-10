package com.springBoot.rushi.week1introduction.introductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name="deploye.env",havingValue="Development")//DEVELOPMENT
public class DevDb implements  TestInterface{

    @Override
    public String getDb(){
        return "Development Database";
    }
}
