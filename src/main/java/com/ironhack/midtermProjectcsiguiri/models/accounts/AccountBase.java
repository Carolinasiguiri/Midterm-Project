package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
public class AccountBase {

    // PROPERTIES ---------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Transient
    private Money balance;
    @OneToOne
    private Users primaryOwner;
    @OneToOne
    private Users secondaryOwner;

    private Double penaltyFee;


    // EMPTY CONSTRUCTOR --------------
    public AccountBase() {

    }

    // CONSTRUCTOR ---------------------
    public AccountBase(Money balance, Users primaryOwner, Users secondaryOwner, Double penaltyFee) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
    }


    // GETTERS AND SETTERS --------------
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Users getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(Users primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public Users getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(Users secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public Double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Double penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
