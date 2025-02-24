package com.RestClient.RestClient.config;


import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;


@Configuration
public class RestClientConfig {

    @Value("${EmployeeService.base.url}")
    private String BASE_URL;


    @Bean
    RestClient getRestClient(){
        System.out.println("--------------------------------------------------- "+BASE_URL+" ----------------------");
        return RestClient
                .builder()
                .baseUrl(BASE_URL)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError,(req,res)->{
                    throw new RuntimeException("Server Error occurred  ");
                })
                .defaultStatusHandler(HttpStatusCode::is4xxClientError,(req,res)->{
                    throw new RuntimeException("Client Error Occurred");
                })
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
