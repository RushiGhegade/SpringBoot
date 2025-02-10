package com.TODOSpringBoot.TODOTASK.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoCongid {


    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

}
