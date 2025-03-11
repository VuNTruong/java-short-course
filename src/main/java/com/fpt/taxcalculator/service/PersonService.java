package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.model.PersonCreateRequestDTO;
import com.fpt.taxcalculator.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void createPerson(PersonCreateRequestDTO request) {
        Map<String, String> errors = new HashMap<>();

        if (Objects.nonNull(request.getFirstName())) {
            errors.put("firstName", "First name field cannot be null");
        }

        if (Objects.nonNull(request.getLastName())) {
            errors.put("lastName", "Last name field cannot be null");
        }

        if (request.getTaxCode().length() >= 2 && request.getTaxCode().length() <= 10) {
            errors.put("taxCode", "Tax code should have between 2 and 10 characters");
        }

        if (request.getIncome() < 0) {
            errors.put("income", "Income should be a positive number");
        }

        Person person = new Person();

        person.setId(request.getId());
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setTaxCode(request.getTaxCode());
        person.setIncome(request.getIncome());

        personRepository.save(person);
    }
}
