package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.config;

import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Auth.AuditAwareImp;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditAwareImp")
public class appConfig {

    @Bean
    ModelMapper getmodelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAware getAuditAwareImp(){
        return new AuditAwareImp();
    }
}
