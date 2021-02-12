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

    private BigDecimal MAX_INTEREST = new BigDecimal(0.5);

    @Transient
    private Money MIN_MINBALANCE = new Money (new BigDecimal(100));

    @Transient
    private Money minBalance = STANDAR_MINBALANCE;

    // EMPTY CONSTRUCTOR ----------------------------------------------------
    public Savings() {

    }


    // CONSTRUCTOR -----------------------------------------------------------
    public Savings(Status status, BigDecimal interest, Money minBalance) throws Exception {
        this.status = status;

        if(MAX_INTEREST.compareTo(interest) == 1) {
            throw new Exception("El interés no puede ser mayor a 0.5");
        } else {
            this.interest = interest;
        }

       if(MIN_MINBALANCE.getAmount().compareTo(minBalance.getAmount()) == 1) {
            throw new Exception("El saldo mínimo no puede ser menor de 100");
        } else {
            this.minBalance = minBalance;
        }

    }

    public Savings(Money balance, Users primaryOwner, Users secondaryOwner, Status status, BigDecimal interest, Money minBalance) throws Exception {
        super(balance, primaryOwner, secondaryOwner);
        this.status = status;

        if(MAX_INTEREST.compareTo(interest) == 1) {
            throw new Exception("El interés no puede ser mayor a 0.5");
        } else {
            this.interest = interest;
        }

        if(MIN_MINBALANCE.getAmount().compareTo(minBalance.getAmount()) == 1) {
            throw new Exception("El saldo mínimo no puede ser menor de 100");
        } else {
            this.minBalance = minBalance;
        }

    }

    public Savings(Money balance, Users primaryOwner, Users secondaryOwner, Status status, BigDecimal interest) throws Exception {
        super(balance, primaryOwner, secondaryOwner);
        this.status = status;

        if(MAX_INTEREST.compareTo(interest) == 1) {
            throw new Exception("El interés no puede ser mayor a 0.5");
        } else {
            this.interest = interest;
        }

    }

    public Savings(Money balance, Users primaryOwner, Users secondaryOwner, Status status, Money minBalance) throws Exception {
        super(balance, primaryOwner, secondaryOwner);
        this.status = status;

        if(MIN_MINBALANCE.getAmount().compareTo(minBalance.getAmount()) == 1) {
            throw new Exception("El saldo mínimo no puede ser menor de 100");
        } else {
            this.minBalance = minBalance;
        }

    }

    @Override
    public Money getBalance() {

        checkInterest(interest, true);

        return getBalance();

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


    @Override
    public void setBalance(Money balance) {

        super.setBalance(balance);
        super.multar(MIN_MINBALANCE);

    }


}