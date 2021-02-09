package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @Transient
    private Money STANDAR_PENALTYFEE = new Money(new BigDecimal(40));


    // EMPTY CONSTRUCTOR --------------
    public AccountBase() {

    }

    // CONSTRUCTOR ---------------------
    public AccountBase(Money balance, Users primaryOwner, Users secondaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
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

    public Money getSTANDAR_PENALTYFEE() {
        return STANDAR_PENALTYFEE;
    }


    public void multar(Money MIN_BALANCE) {

        if(getBalance().getAmount().compareTo(MIN_BALANCE.getAmount()) == -1) {

            this.balance = (new Money(getBalance().decreaseAmount(STANDAR_PENALTYFEE)));

        }

    }


}
