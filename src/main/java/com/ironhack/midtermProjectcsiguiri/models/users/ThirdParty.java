package com.ironhack.midtermProjectcsiguiri.models.users;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;

@Entity
@DynamicUpdate
public class ThirdParty extends Users{

    // PROPERTIES ------------------------
    private String hashKey;


    // EMPTY CONSTRUCTOR -----------------
    public ThirdParty() {

    }

    // CONSTRUCTOR -----------------------
    public ThirdParty(String hashKey) {
        this.hashKey = hashKey;
    }

    public ThirdParty(String name, String hashKey) {
        super(name);
        this.hashKey = hashKey;
    }


    // GETTERS AND SETTERS ---------------
    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}
