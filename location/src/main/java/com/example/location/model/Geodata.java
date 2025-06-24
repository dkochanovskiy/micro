package com.example.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Geodata {
    @Id
    @GeneratedValue
    private int id;

    private double longitude;
    private double latitude;
    private String name;

    public Geodata() {
    }

    public Geodata(int id, double longitude, double latitude, String name) {
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
