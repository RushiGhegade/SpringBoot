package com.StudentdatabaseAdvance.Studentdatabase;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class modelmapper {

    @Bean
    public ModelMapper getmodelMappper(){
        return new ModelMapper();
    }
}
