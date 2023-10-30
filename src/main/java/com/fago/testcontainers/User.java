package com.fago.testcontainers;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    private UUID id;
    private String name;
    private String age;

    protected User() {
        //JPA
    }

    public User(UUID id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
