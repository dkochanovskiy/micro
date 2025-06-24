package com.example.location.controller;

import com.example.location.model.Location;
import com.example.location.model.Weather;
import com.example.location.repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private static final Logger LOG = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.url}")
    String weatherUrl;

    @GetMapping("/weather")
    public Weather redirectRequestWeather(@RequestParam String name) {

        Location location = getLocationByName(name);

        LOG.info(location.toString());

        String url = String.format("https://%s/weather?lat=%s&lon=%s", weatherUrl, location.getLatitude(), location.getLongitude());

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
