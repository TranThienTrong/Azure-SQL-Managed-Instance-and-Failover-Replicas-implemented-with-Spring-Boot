package com.example.spring_data.controller;

import com.example.spring_data.model.Person;
import com.example.spring_data.repository.primary.PrimaryPersonRepository;

import com.example.spring_data.repository.secondary.SecondaryPersonRepository;
import com.example.spring_data.service.PersonService;
import com.example.spring_data.service.ReadOnlyPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    ReadOnlyPersonService readOnlyPersonService;


    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return readOnlyPersonService.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        return readOnlyPersonService.getPersonById(id);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
            return personService.createPerson(person);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") Long id) {
        return personService.deletePerson(id);
    }

    @DeleteMapping("/persons")
    public ResponseEntity<HttpStatus> deleteAllPersons() {
        return personService.deleteAllPersons();
    }


}
