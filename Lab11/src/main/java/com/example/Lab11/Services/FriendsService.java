package com.example.Lab11.Services;

import com.example.Lab11.Entities.FriendsEntity;
import com.example.Lab11.Entities.PersonEntity;
import com.example.Lab11.Repositories.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsService {

    private final FriendsRepository friendsRepository;

    @Autowired
    public FriendsService(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    public List<FriendsEntity> getRelationships() {
        return friendsRepository.findAll();
    }
}
