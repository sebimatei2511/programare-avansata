package repositories;

import entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository
        extends JpaRepository<PersonEntity, Long> {

    @Modifying
    @Query("update PersonEntity p set p.name = ?2 where p.id = ?1")
    void update(Integer id, String name);
}
