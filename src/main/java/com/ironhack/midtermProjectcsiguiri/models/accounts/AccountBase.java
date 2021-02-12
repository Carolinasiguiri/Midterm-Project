package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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

    private Date creationDate;
    private Date interestDate;

    private Date lastTransaction;


    // EMPTY CONSTRUCTOR --------------
    public AccountBase() {

    }

    // CONSTRUCTOR ---------------------
    public AccountBase(Money balance, Users primaryOwner, Users secondaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.creationDate = new Date();
        this.interestDate = creationDate;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getInterestDate() {
        return interestDate;
    }

    public void setInterestDate(Date interestDate) {
        this.interestDate = interestDate;
    }

    public Date getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(Date lastTransaction) {
        this.lastTransaction = lastTransaction;
    }



    public void multar(Money MIN_BALANCE) {

        if(getBalance().getAmount().compareTo(MIN_BALANCE.getAmount()) == -1) {

            this.balance = (new Money(getBalance().decreaseAmount(STANDAR_PENALTYFEE)));

        }

    }


    public void checkInterest(BigDecimal interest, Boolean isAnual) {

       Date date = new Date(getInterestDate().toString());

        if(isAnual) date.setYear(date.getYear()+1);
        else date.setMonth(date.getMonth()+1);


        if(date.compareTo(new Date()) == -1) {

            setBalance(new Money(getBalance().increaseAmount(getBalance().getAmount().multiply(interest))));

            setInterestDate(new Date());

        }

    }


}
