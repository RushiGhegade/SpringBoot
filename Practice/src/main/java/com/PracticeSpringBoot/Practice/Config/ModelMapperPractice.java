package com.PracticeSpringBoot.Practice.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperPractice {

    @Bean
    public ModelMapper GetModelMapper(){
        return new ModelMapper();
    }

}
