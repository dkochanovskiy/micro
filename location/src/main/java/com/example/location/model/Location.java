package com.example.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String locationName;

    @NonNull
    private double latitude;

    @NonNull
    private double longitude;

    @NonNull
    private String country;

    @NonNull
    private String city;

    public Location(@NonNull String locationName, @NonNull Double latitude, @NonNull Double longitude, @NonNull String country, @NonNull String city) {
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
