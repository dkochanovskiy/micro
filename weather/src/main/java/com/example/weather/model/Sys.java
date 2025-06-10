package com.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sys {

    private String country;
    private int sunrise;
    private int sunset;
}
