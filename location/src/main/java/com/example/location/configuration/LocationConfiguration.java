package com.example.location.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LocationConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }
}
