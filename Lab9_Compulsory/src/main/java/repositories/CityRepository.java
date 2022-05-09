package repositories;

import entities.Country;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class CityRepository {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


}
