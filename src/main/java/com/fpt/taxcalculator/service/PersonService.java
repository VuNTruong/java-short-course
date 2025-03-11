package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.model.PersonCreateRequestDTO;
import com.fpt.taxcalculator.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Person person = new Person();

        person.setId(request.getId());
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setTaxCode(request.getTaxCode());
        person.setIncome(request.getIncome());

        personRepository.save(person);
    }
}
