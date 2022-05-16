package controllers;

import entities.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.PersonService;

import javax.persistence.Persistence;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<PersonEntity> getPersons() {
        return personService.getPersons();
    }

    @PostMapping
    public void addPerson(@RequestBody PersonEntity personEntity) {
        personService.addPerson(personEntity);
    }

    @DeleteMapping
    public void deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(Math.toIntExact(id));
    }

    @PutMapping
    public void setName(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name) {
        personService.setName(Math.toIntExact(id), name);
    }


}
