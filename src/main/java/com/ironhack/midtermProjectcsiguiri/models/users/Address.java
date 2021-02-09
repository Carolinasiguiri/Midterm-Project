package com.ironhack.midtermProjectcsiguiri.models.users;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Embeddable
public class Address {

    // PROPERTIES ----------------------------------------------------------------------
    private String address;
    private int number;
    private String country;
    private String city;


    // EMPTY CONSTRUCTOR ----------------------------------------------------------------
    public Address() {

    }


    // CONSTRUCTOR ----------------------------------------------------------------------
    public Address(String address, int number, String country, String city) {
        this.address = address;
        this.number = number;
        this.country = country;
        this.city = city;

    }



    // GETTERS AND SETTERS --------------------------------------------------------------
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
