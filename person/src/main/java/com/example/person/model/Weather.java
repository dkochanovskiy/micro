package com.example.person.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("feels_like")
    private double feelsLike;

    @JsonProperty("temp_min")
    private double tempMin;

    @JsonProperty("temp_max")
    private double tempMax;

    private int pressure;

    private int humidity;

    @JsonProperty("sea_level")
    private int seaLevel;

    @JsonProperty("grnd_level")
    private int grndLevel;

    public Weather() {
    }

    public Weather(double temp, double feelsLike, double tempMin, double tempMax, int pressure, int humidity, int seaLevel,
                   int grndLevel) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public int getGrndLevel() {
        return grndLevel;
    }
}
