package com.example.weather.service;

import com.example.weather.model.Main;

public interface WeatherCacheService {

    Main getCachedWeather(String lat, String lon);
}
