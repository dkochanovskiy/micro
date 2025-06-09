package com.example.weather.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String temperature;

    @NonNull
    private String humidity;

    @NonNull
    private String pressure;

    public Integer getId() {
        return id;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public Weather(@NonNull String temperature, @NonNull String humidity, @NonNull String pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }
}
