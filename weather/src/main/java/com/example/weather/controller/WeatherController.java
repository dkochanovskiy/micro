package com.example.weather.controller;

import com.example.weather.model.Main;
import com.example.weather.service.impl.WeatherCacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    WeatherCacheServiceImpl weatherCacheServiceImpl;

    @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public Main getWeather(@RequestParam String lat, @RequestParam String lon) {

        return weatherCacheServiceImpl.getCachedWeather(lat, lon);
    }
}
