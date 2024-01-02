package com.example.agcbiohardwareinventorysystembackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// This class is for the Login entity in the database

//This annotation is used to mark the class as an entity class which means that it will be mapped to a table in the database
@Entity
public class Login {
    // This annotation is used to mark the primary key of the table in the database, and it is auto incremented by 1 for each new record added to the table
    @Id
    // @GeneratedValue is used to specify the strategy used for the primary key generation for the table in the database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
