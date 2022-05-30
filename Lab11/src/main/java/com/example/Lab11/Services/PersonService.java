package com.example.Lab11.Services;

import com.example.Lab11.Entities.PersonEntity;
import com.example.Lab11.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> getPersons() {
        return personRepository.findAll();
    }

    public Optional<PersonEntity> getPerson(Long id) {
        return getPerson(id);
    }

    public void addPerson(PersonEntity personEntity) {
        Optional<PersonEntity> personOptional =
                personRepository.findPersonEntityByName(personEntity.getName());
        if (personOptional.isPresent()) {
            throw new IllegalStateException("name already exists!");
        }
        personRepository.save(personEntity);
    }

    public void deletePerson(Long personId) {
        personRepository.findById(personId);
        boolean exists = personRepository.existsById(personId);
        if (!exists) {
            throw new IllegalStateException("User with id " + personId + " does not exist!");
        }
        personRepository.deleteById(personId);
    }

    @Transactional
    public void updatePerson(
            Long personId,
            String name
    ) {
        PersonEntity personEntity = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + personId + " does not exist!"
                ));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(personEntity.getName(), name)) {
            personEntity.setName(name);
        }
    }
}
