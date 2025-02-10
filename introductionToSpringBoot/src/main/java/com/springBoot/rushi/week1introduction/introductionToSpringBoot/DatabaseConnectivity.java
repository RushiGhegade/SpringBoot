package com.springBoot.rushi.week1introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConnectivity {

    @Autowired
    private TestInterface obj;

    void getDatabase(){
        System.out.println(obj.getDb());
    }

}
