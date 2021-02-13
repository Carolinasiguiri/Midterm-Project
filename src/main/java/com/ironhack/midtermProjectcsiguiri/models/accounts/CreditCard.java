package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CreditCard extends AccountBase{

    // PROPERTIES ----------------------------
    @Transient
    private BigDecimal STANDAR_INTEREST = new BigDecimal(0.2);
    private BigDecimal interest = STANDAR_INTEREST;

    @Transient
    private Money STANDAR_CREDITMAX = new Money(new BigDecimal(100));


   @Transient
    private Money MAX_CREDITMAX = new Money(new BigDecimal(100.000));

    @AttributeOverrides({
            @AttributeOverride( name = "currency", column = @Column(name = "credit_limit_currency")),
            @AttributeOverride( name = "amount", column = @Column(name = "credit_limit_amount"))
    })

    private Money creditLimit;
    @Transient
    private BigDecimal MIN_INTEREST = new BigDecimal(0.1);

    // EMPTY CONSTRUCTOR ---------------------
    public CreditCard() {

    }


    // CONSTRUCTOR ---------------------------
    public CreditCard(BigDecimal interest, Money creditLimit) throws Exception {

        if(MIN_INTEREST.compareTo(interest) == -1) {
            throw new Exception("El interés no puede ser menor a 0.1");
        } else {
            this.interest = interest;
        }

        if(STANDAR_CREDITMAX.getAmount().compareTo(creditLimit.getAmount()) == 1) {
            throw new Exception("El límite de crédito no puede ser menor de 100");
        } else if(MAX_CREDITMAX.getAmount().compareTo(creditLimit.getAmount()) == -1) {
            throw new Exception("El límite de crédito no puede ser superior a 100.000");
        } else {
            this.creditLimit = creditLimit;
        }

    }

    public CreditCard(Money balance, Users primaryOwner, Users secondaryOwner, Money creditLimit, BigDecimal interest) throws Exception {

        super(balance, primaryOwner, secondaryOwner);

        if(MIN_INTEREST.compareTo(interest) == -1) {
            throw new Exception("El interés no puede ser menor a 0.1");
        } else {
            this.interest = interest;
        }

        if(STANDAR_CREDITMAX.getAmount().compareTo(creditLimit.getAmount()) == 1) {
            throw new Exception("El límite de crédito no puede ser menor de 100");
        } else if(MAX_CREDITMAX.getAmount().compareTo(creditLimit.getAmount()) == -1) {
            throw new Exception("El límite de crédito no puede ser superior a 100.000");
        } else {
            this.creditLimit = creditLimit;
        }

    }

    public CreditCard(Money balance, Users primaryOwner, Users secondaryOwner, Money creditLimit) throws Exception {

        super(balance, primaryOwner, secondaryOwner);


        if(STANDAR_CREDITMAX.getAmount().compareTo(creditLimit.getAmount()) == 1) {
            throw new Exception("El límite de crédito no puede ser menor de 100");
        } else if(MAX_CREDITMAX.getAmount().compareTo(creditLimit.getAmount()) == -1) {
            throw new Exception("El límite de crédito no puede ser superior a 100.000");
        } else {
            this.creditLimit = creditLimit;
        }

    }

    public CreditCard(Money balance, Users primaryOwner, Users secondaryOwner, BigDecimal interest) throws Exception {

        super(balance, primaryOwner, secondaryOwner);

        if(MIN_INTEREST.compareTo(interest) == -1) {
            throw new Exception("El interés no puede ser menor a 0.1");
        } else {
            this.interest = interest;
        }

    }


    // GETTERS AND SETTERS -------------------
    public Money getCreditMax() {
        return STANDAR_CREDITMAX;
    }


    public Money getMAX_CREDITMAX() {
        return MAX_CREDITMAX;
    }


    @Override
    public Money getBalance() {

        checkInterest(interest, false);

        return getBalance();

    }

}


