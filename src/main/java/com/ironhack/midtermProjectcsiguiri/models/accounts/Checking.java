package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.enums.Status;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;


@Entity
public class Checking extends AccountBase{


    // PROPERTIES ------------------------------
    private int secretKey;
    @Transient
    private Money minimumBalance;
    @Transient
    private Money monthlyMaintenanceFee;

    @Enumerated(EnumType.STRING)
    private Status status;


    // EMPTY CONSTRUCTOR -----------------------
    public Checking() {

    }

    // CONSTRUCTOR -----------------------------
    public Checking(int secretKey, Money minimumBalance, Money monthlyMaintenanceFee, Status status) {
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.status = status;
    }

    public Checking(Money balance, Users primaryOwner, Users secondaryOwner, Double penaltyFee, int secretKey, Money minimumBalance, Money monthlyMaintenanceFee, Status status) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.status = status;
    }


    // GETTERS AND SETTERS ---------------------

    public int getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(int secretKey) {
        this.secretKey = secretKey;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}

