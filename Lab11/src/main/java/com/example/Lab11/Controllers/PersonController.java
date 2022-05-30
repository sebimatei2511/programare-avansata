package com.example.Lab11.Controllers;


import com.example.Lab11.Entities.PersonEntity;
import com.example.Lab11.Services.FriendsService;
import com.example.Lab11.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/lab11/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @RequestMapping("/hello")
    public String Hello() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping
    public List<PersonEntity> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/count")
    public int countProducts() {
        return personService.getPersons().size();
    }

    @GetMapping("/{id}")
    public Optional<PersonEntity> getPerson(@PathVariable("id") Long id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public void addPerson(@RequestBody PersonEntity personEntity) {
        personService.addPerson(personEntity);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "/{id}")
    public void updatePerson(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name) {
        personService.updatePerson(id, name);
    }


}
