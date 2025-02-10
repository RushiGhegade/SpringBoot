package com.Homework.Homework.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class modelmapper {

    @Bean
    public ModelMapper getmodelmapper(){
        return new ModelMapper();
    }

}
