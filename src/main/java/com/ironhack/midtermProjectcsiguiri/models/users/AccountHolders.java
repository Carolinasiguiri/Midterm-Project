package com.ironhack.midtermProjectcsiguiri.models.users;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.enums.Status;
import com.ironhack.midtermProjectcsiguiri.models.accounts.AccountBase;
import com.ironhack.midtermProjectcsiguiri.models.accounts.Checking;
import com.ironhack.midtermProjectcsiguiri.models.accounts.StudentChecking;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccountHolders extends Users{


    // PROPERTIES ---------------------------
    private Date birth;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "primaryAddress_address")),
            @AttributeOverride(name = "number", column = @Column(name = "primaryAddress_number")),
            @AttributeOverride(name = "country", column = @Column(name = "primaryAddress_country")),
            @AttributeOverride(name = "city", column = @Column(name = "primaryAddress_city"))
    })
    private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "mailingAddress_address")),
            @AttributeOverride(name = "number", column = @Column(name = "mailingAddress_number")),
            @AttributeOverride(name = "country", column = @Column(name = "mailingAddress_country")),
            @AttributeOverride(name = "city", column = @Column(name = "mailingAddress_city"))
    })
    private Address mailingAddress;


    // EMPTY CONSTRUCTOR --------------------
    public AccountHolders() {

    }


    // CONSTRUCTOR --------------------------
    public AccountHolders(Date birth, Address primaryAddress, Address mailingAddress) {
        this.birth = birth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public AccountHolders(String name, Date birth, Address primaryAddress, Address mailingAddress) {
        super(name);
        this.birth = birth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }


    // GETTERS AND SETTERS -------------------

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }


    public AccountBase createChecking(Money balance, Users secondaryOwner, Status status, int secretKey) {


        if((new Date().getYear() - birth.getYear()) < 24) {

          return new StudentChecking(balance, this, secondaryOwner, status, secretKey);

        }
        return new Checking(balance, this, secondaryOwner, secretKey, status);

    }

}
