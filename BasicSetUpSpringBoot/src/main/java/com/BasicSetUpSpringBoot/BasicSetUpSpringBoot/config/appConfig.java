package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appConfig {

    @Bean
    ModelMapper getmodelMapper(){
        return new ModelMapper();
    }
}
