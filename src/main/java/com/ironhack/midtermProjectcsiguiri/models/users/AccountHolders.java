package com.ironhack.midtermProjectcsiguiri.models.users;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccountHolders extends Users{


    // PROPERTIES ---------------------------
    private Date birth;

    @ManyToOne
    private PrimaryAddress primaryAddress;


    // EMPTY CONSTRUCTOR --------------------
    public AccountHolders() {

    }


    // CONSTRUCTOR --------------------------
    public AccountHolders(Date birth, PrimaryAddress primaryAddress) {
        this.birth = birth;
        this.primaryAddress = primaryAddress;
    }

    public AccountHolders(String name, Date birth, PrimaryAddress primaryAddress) {
        super(name);
        this.birth = birth;
        this.primaryAddress = primaryAddress;
    }


    // GETTERS AND SETTERS -------------------

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public PrimaryAddress getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(PrimaryAddress primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
}
