package com.example.location.controller;

import com.example.location.model.Location;
import com.example.location.model.Weather;
import com.example.location.repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/weather")
    public Weather redirectRequestWeather(@RequestParam String name) {

        Location location = getLocationByName(name);

        String url = String.format("http://localhost:8082/weather?lat=%s&lon=%s", location.getLatitude(), location.getLongitude());

        return restTemplate.getForObject(url, Weather.class);
    }

    @GetMapping
    public List<Location> getLocation() {

        return (List<Location>) locationRepository.findAll();
    }

    @GetMapping("/getByName")
    public Location getLocationByName (@RequestParam String name) {

        return locationRepository.getLocationByName(name);
    }

    @PostMapping
    public Location addLocation (@RequestBody Location location) {

        return locationRepository.save(location);
    }

    @PutMapping
    @Transactional
    public Location upadteLocation (@RequestParam String name, @RequestBody Location location) {

        Location existsLoc = locationRepository.getLocationByName(name);

        existsLoc.setName(location.getName());
        existsLoc.setLatitude(location.getLatitude());
        existsLoc.setLongitude(location.getLongitude());

        return locationRepository.save(existsLoc);
    }

    @DeleteMapping
    @Transactional
    public void deleteLocationByName (@RequestParam String name) {

        locationRepository.deleteByName(name);
    }
}
