package com.example.weather.service.impl;

import com.example.weather.controller.WeatherController;
import com.example.weather.model.Main;
import com.example.weather.model.Root;
import com.example.weather.service.WeatherCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherCacheServiceImpl implements WeatherCacheService {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${appid}")
    private String appId;

    @Value("${url.weather}")
    private String urlWeather;

    @Cacheable("weathers")
    public Main getCachedWeather(String lat, String lon) {

        String request = String.format("%s?lat=%s&lon=%s&units=metric&appid=%s",
                urlWeather, lat, lon, appId);

        LOG.info("Выполняется запрос к API погоды для координат: {}, {}", lat, lon);

        return restTemplate.getForObject(request, Root.class).getMain();
    }
}
