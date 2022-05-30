package com.example.Lab11.Repositories;

import com.example.Lab11.Entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository
        extends JpaRepository<PersonEntity, Long> {
    @Query("SELECT p FROM PersonEntity p WHERE p.name = ?1")
    Optional<PersonEntity> findPersonEntityByName(String name);

    @Query("SELECT p FROM PersonEntity p WHERE p.id = ?1")
    Optional<PersonEntity> findPersonEntityById(String name);
}
