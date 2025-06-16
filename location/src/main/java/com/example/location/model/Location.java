package com.example.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private double latitude;

    @NonNull
    private double longitude;

    public Location() {
    }

    public Location(@NonNull String name, @NonNull Double latitude, @NonNull Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
