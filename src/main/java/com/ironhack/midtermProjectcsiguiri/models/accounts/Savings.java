package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.enums.Status;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Savings extends AccountBase{


    // PROPERTIES -----------------------------------------------------------
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal STANDAR_INTEREST = new BigDecimal(0.0025);
    private BigDecimal interest = STANDAR_INTEREST;
    @Transient
    private Money STANDAR_MINBALANCE = new Money(new BigDecimal(1000));


    // EMPTY CONSTRUCTOR ----------------------------------------------------
    public Savings() {

    }


    // CONSTRUCTOR -----------------------------------------------------------
    public Savings(Status status, BigDecimal interest) {
        this.status = status;
        this.interest = interest;
    }

    public Savings(Money balance, Users primaryOwner, Users secondaryOwner, Double penaltyFee, Status status, BigDecimal interest) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.status = status;
        this.interest = interest;
    }


    // GETTERS AND SETTER -----------------------------------------------------
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }
}