package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.enums.Status;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class Checking extends AccountBase{


    // PROPERTIES ------------------------------
    private int secretKey;
    @Transient
    private Money STANDAR_MINBALANCE = new Money(new BigDecimal(250));
    @Transient
    private Money STANDAR_MONTHLYMAINTENANCEFEE = new Money(new BigDecimal(12));


    @Enumerated(EnumType.STRING)
    private Status status;


    // EMPTY CONSTRUCTOR -----------------------
    public Checking() {

    }

    // CONSTRUCTOR -----------------------------
    public Checking(int secretKey, Money STANDAR_MINBALANCE, Money STANDAR_MONTHLYMAINTENANCEFEE, Status status) {
        this.secretKey = secretKey;
        this.STANDAR_MINBALANCE = STANDAR_MINBALANCE;
        this.STANDAR_MONTHLYMAINTENANCEFEE = STANDAR_MONTHLYMAINTENANCEFEE;
        this.status = status;
    }

    public Checking(Money balance, Users primaryOwner, Users secondaryOwner, Money penaltyFee, int secretKey, Money STANDAR_MINBALANCE, Money STANDAR_MONTHLYMAINTENANCEFEE, Status status) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.STANDAR_MINBALANCE = STANDAR_MINBALANCE;
        this.STANDAR_MONTHLYMAINTENANCEFEE = STANDAR_MONTHLYMAINTENANCEFEE;
        this.status = status;
    }


    // GETTERS AND SETTERS ---------------------

    public int getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(int secretKey) {
        this.secretKey = secretKey;
    }

    public Money getSTANDAR_MINBALANCE() {
        return STANDAR_MINBALANCE;
    }

    public Money getSTANDAR_MONTHLYMAINTENANCEFEE() {
        return STANDAR_MONTHLYMAINTENANCEFEE;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}

