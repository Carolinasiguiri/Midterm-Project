package com.ironhack.midtermProjectcsiguiri.models.users;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Admins extends Users{


    // EMPTY CONSTRUCTOR --------------------------
    public Admins() {

    }

    // CONSTRUCTOR --------------------------------
    public Admins(String name) {
        super(name);
    }

}
