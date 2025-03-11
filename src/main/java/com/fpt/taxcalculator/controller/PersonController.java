package com.fpt.taxcalculator.controller;

import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.model.PersonCreateRequestDTO;
import com.fpt.taxcalculator.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void create(@RequestBody @Valid PersonCreateRequestDTO request) {
        personService.createPerson(request);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }
}
