package com.ironhack.midtermProjectcsiguiri.models.users;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DynamicUpdate
public class Users {

    // PROPERTIES -----------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    // EMPTY CONSTRUCTOR ----------
    public Users() {

    }

    // CONSTRUCTOR ----------------
    public Users(String name) {
        this.name = name;
    }


    // GETTERS AND SETTERS --------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
