package com.example.Lab11.Repositories;

import com.example.Lab11.Entities.FriendsEntity;
import com.example.Lab11.Entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FriendsRepository
        extends JpaRepository<FriendsEntity, Long> {

    @Query("SELECT f FROM FriendsEntity f WHERE f.friend1 = ?1")
    Optional<PersonEntity> findPersonEntityByFriend1(String name);

    @Query("SELECT f FROM FriendsEntity f WHERE f.friend2 = ?1")
    Optional<PersonEntity> findPersonEntityByFriend2(String name);

}
