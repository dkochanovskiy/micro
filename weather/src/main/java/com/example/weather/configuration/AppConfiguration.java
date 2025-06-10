package com.example.weather.configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Scheduler;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.List;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setMessageConverters(List.of(
                new MappingJackson2HttpMessageConverter()
        ));

        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().setAccept(List.of(MediaType.APPLICATION_JSON));
            return execution.execute(request, body);
        });

        return restTemplate;
    }

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("weathers");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(Duration.ofSeconds(10))
                .scheduler(Scheduler.systemScheduler())
                .maximumSize(100)
                .recordStats());

        return new ConcurrentMapCacheManager("weathers");
    }
}
