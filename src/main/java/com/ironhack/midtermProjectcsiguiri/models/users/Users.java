package com.ironhack.midtermProjectcsiguiri.models.users;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
