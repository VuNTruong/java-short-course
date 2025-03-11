package com.fpt.taxcalculator.controller;

import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.model.PersonCreateRequestDTO;
import com.fpt.taxcalculator.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void create(PersonCreateRequestDTO request) {
        personService.createPerson(request);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public Person getById(Long id) {
        return personService.getPersonById(id);
    }
}
