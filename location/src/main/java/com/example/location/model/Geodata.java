package com.example.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NonNull;

@Entity
public class Geodata {


    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private double longitude;
    @NonNull private double latitude;
    @NonNull private String name;

    public Geodata() {
    }

    public Geodata(int id, @NonNull double longitude, @NonNull double latitude, @NonNull String name) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }
}
