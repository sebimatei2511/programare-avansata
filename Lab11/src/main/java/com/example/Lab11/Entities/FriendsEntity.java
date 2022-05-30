package com.example.Lab11.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class FriendsEntity {

    @Id
    @SequenceGenerator(
            name = "friends_sequence",
            sequenceName = "friends_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "friends_sequence"
    )
    private Long id;

    @Column
    private Long friend1;

    @Column
    private Long friend2;

    public FriendsEntity() {
    }

    public FriendsEntity(Long friend1, Long friend2) {
        this.friend1 = friend1;
        this.friend2 = friend2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFriend1() {
        return friend1;
    }

    public void setFriend1(Long friend1) {
        this.friend1 = friend1;
    }

    public Long getFriend2() {
        return friend2;
    }

    public void setFriend2(Long friend2) {
        this.friend2 = friend2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendsEntity friends)) return false;
        return getId().equals(friends.getId())
                && getFriend1().equals(friends.getFriend1())
                && getFriend2().equals(friends.getFriend2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFriend1(), getFriend2());
    }

    @Override
    public String toString() {
        return "FriendsEntity{" +
                "id=" + id +
                ", friend1=" + friend1 +
                ", friend2=" + friend2 +
                '}';
    }
}
