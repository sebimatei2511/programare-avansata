package com.example.Lab11.Config;

import com.example.Lab11.Entities.FriendsEntity;
import com.example.Lab11.Entities.PersonEntity;
import com.example.Lab11.Repositories.FriendsRepository;
import com.example.Lab11.Repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FriendsConfig {

    @Bean
    CommandLineRunner commandLineRunner2(FriendsRepository repository) {
        return args -> {
            FriendsEntity friendsRelationship1 = new FriendsEntity(1L,2L);
            FriendsEntity friendsRelationship2 = new FriendsEntity(1L,3L);
            FriendsEntity friendsRelationship3 = new FriendsEntity(1L,4L);
            FriendsEntity friendsRelationship4 = new FriendsEntity(1L,5L);

            FriendsEntity friendsRelationship5 = new FriendsEntity(2L,1L);

            FriendsEntity friendsRelationship6 = new FriendsEntity(3L,1L);

            FriendsEntity friendsRelationship7 = new FriendsEntity(4L,1L);

            FriendsEntity friendsRelationship8 = new FriendsEntity(5L,1L);

            FriendsEntity friendsRelationship9 = new FriendsEntity(6L,7L);
            FriendsEntity friendsRelationship10 = new FriendsEntity(6L,8L);
            FriendsEntity friendsRelationship11 = new FriendsEntity(6L,9L);

            FriendsEntity friendsRelationship12 = new FriendsEntity(7L,6L);

            FriendsEntity friendsRelationship13 = new FriendsEntity(8L,6L);

            FriendsEntity friendsRelationship14 = new FriendsEntity(9L,6L);
            FriendsEntity friendsRelationship15 = new FriendsEntity(9L,10L);

            FriendsEntity friendsRelationship16 = new FriendsEntity(10L,9L);
            FriendsEntity friendsRelationship17 = new FriendsEntity(10L,11L);

            FriendsEntity friendsRelationship18 = new FriendsEntity(11L,10L);

            FriendsEntity friendsRelationship19 = new FriendsEntity(13L,14L);

            FriendsEntity friendsRelationship20 = new FriendsEntity(14L,13L);


            repository.saveAll(List.of(friendsRelationship1, friendsRelationship2, friendsRelationship3,friendsRelationship4,friendsRelationship5,friendsRelationship6,
                    friendsRelationship7,friendsRelationship8,friendsRelationship9,friendsRelationship10,friendsRelationship11,friendsRelationship12,friendsRelationship13,
                    friendsRelationship14,friendsRelationship15,friendsRelationship16,friendsRelationship17,friendsRelationship18,friendsRelationship19,friendsRelationship20));
        };
    }

}
