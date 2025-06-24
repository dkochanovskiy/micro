package com.example.weather.model;

public class Sys {

    private String country;
    private int sunrise;
    private int sunset;

    public Sys() {
    }

    public Sys(String country, int sunrise, int sunset) {
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getCountry() {
        return country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }
}
