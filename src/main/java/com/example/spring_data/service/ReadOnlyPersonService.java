package com.example.spring_data.service;

import com.example.spring_data.model.Person;
import com.example.spring_data.repository.primary.PrimaryPersonRepository;
import com.example.spring_data.repository.secondary.SecondaryPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReadOnlyPersonService {
    @Autowired
    SecondaryPersonRepository personRepository;

    public ResponseEntity<List<Person>> getAllPersons() {
        try {
            List<Person> personList = new ArrayList<>();

            personList.addAll(personRepository.findAll());

            if (personList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(personList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        Optional<Person> personData = personRepository.findById(id);

        if (personData.isPresent()) {
            return new ResponseEntity<>(personData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
