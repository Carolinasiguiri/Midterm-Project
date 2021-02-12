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
import java.util.Date;


@Entity
public class Checking extends AccountBase{


    // PROPERTIES ------------------------------
    private int secretKey;
    @Transient
    private Money STANDAR_MINBALANCE = new Money(new BigDecimal(250));
    @Transient
    private Money STANDAR_MONTHLYMAINTENANCEFEE = new Money(new BigDecimal(12));
    @Transient
    private Money monthlyMaintenanceFee = STANDAR_MONTHLYMAINTENANCEFEE;
    @Transient
    private Money minBalance = STANDAR_MINBALANCE;


    @Enumerated(EnumType.STRING)
    private Status status;


    // EMPTY CONSTRUCTOR -----------------------
    public Checking() {

    }

    // CONSTRUCTOR -----------------------------
    public Checking(int secretKey, Status status) {
        this.secretKey = secretKey;
        this.status = status;
    }

    public Checking(Money balance, Users primaryOwner, Users secondaryOwner, int secretKey, Status status) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
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

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Money getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(Money minBalance) {
        this.minBalance = minBalance;
    }


    @Override
    public void setBalance(Money balance) {

        super.setBalance(balance);
        super.multar(STANDAR_MINBALANCE);

    }

    public boolean checkInSeg() {

        Date checkDate = getLastTransaction();

        checkDate.setHours(checkDate.getSeconds()+1);

        if(checkDate.compareTo(new Date()) == 1 ){

            return true;

        }

        return false;

    }

}

