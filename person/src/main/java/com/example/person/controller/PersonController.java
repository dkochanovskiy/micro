package com.example.person.controller;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.person.model.Weather;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${location.url}")
    String locationUrl;

    @GetMapping("/{id}/weather")
    public ResponseEntity<Weather> getWeather(@PathVariable int id) {
        if (repository.existsById(id)) {

            String location = repository.findById(id).get().getLocation();

            String url = String.format("http://%s/location/weather?name", locationUrl);

            Weather weather = restTemplate.getForObject(url + location, Weather.class);

            return new ResponseEntity(weather, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return repository.findById(person.getId()).isPresent()
                ? new ResponseEntity(repository.findById(person.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(repository.save(person), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Person person) {

        Optional<Person> personOptional = repository.findById(id);

        Person personFromDb = personOptional.orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Person not found"
        ));

        personFromDb.setName(person.getName());
        personFromDb.setLocation(person.getLocation());
        personFromDb.setFirstname(person.getFirstname());
        personFromDb.setLastname(person.getLastname());
        personFromDb.setSurname(person.getSurname());

        repository.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

        repository.deleteById(id);
    }
}
