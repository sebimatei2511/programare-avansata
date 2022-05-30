package com.example.Lab11.Config;

import com.example.Lab11.Entities.PersonEntity;
import com.example.Lab11.Repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
            PersonEntity alin = new PersonEntity("Alin");
            PersonEntity bianca = new PersonEntity("Bianca");
            PersonEntity cornel = new PersonEntity("Cornel");
            PersonEntity denisa = new PersonEntity("Denisa");
            PersonEntity emi = new PersonEntity("Emi");
            PersonEntity fiona = new PersonEntity("Fiona");
            PersonEntity george = new PersonEntity("George");
            PersonEntity horia = new PersonEntity("Horia");
            PersonEntity ilona = new PersonEntity("ilona");
            PersonEntity luisa = new PersonEntity("Luisa");
            PersonEntity mircea = new PersonEntity("Mircea");
            PersonEntity nico = new PersonEntity("Nico");
            PersonEntity oana = new PersonEntity("Oana");
            PersonEntity petru = new PersonEntity("Petru");
            PersonEntity radu = new PersonEntity("Radu");
            PersonEntity sonia = new PersonEntity("Sonia");
            PersonEntity octavian = new PersonEntity("Octavian");
            PersonEntity victor = new PersonEntity("Victor");
            PersonEntity silvia = new PersonEntity("Silvia");
            PersonEntity andrei = new PersonEntity("Andrei");

            repository.saveAll(List.of(alin,bianca,cornel,denisa,emi,fiona,george,horia,ilona,luisa,mircea,nico,oana,petru,radu,sonia,octavian,victor,silvia,andrei));
        };
    }
}
