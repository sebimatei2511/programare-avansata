package services;

import entities.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PersonRepository;

import java.util.List;

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

    public void addPerson(PersonEntity name) {
        personRepository.save(name);
    }

    public void setName(Integer id, String string) {
        if (string == null)
            return;
        personRepository.update(id,string);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(Long.valueOf(id));
    }
}
