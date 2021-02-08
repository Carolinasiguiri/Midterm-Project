package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Entity
public class CreditCard extends AccountBase{

    // PROPERTIES ----------------------------
    private BigDecimal STANDAR_INTEREST = new BigDecimal(0.2);
    private BigDecimal interest = STANDAR_INTEREST;
    @Transient
    private Money STANDAR_CREDITMAX = new Money(new BigDecimal(100));

    // EMPTY CONSTRUCTOR ---------------------
    public CreditCard() {

    }


    // CONSTRUCTOR ---------------------------
    public CreditCard(BigDecimal STANDAR_INTEREST, Money creditMax) {

        this.STANDAR_CREDITMAX = creditMax;

    }

    public CreditCard(Money balance, Users primaryOwner, Users secondaryOwner, Double penaltyFee, Money creditMax) {

        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.STANDAR_CREDITMAX = creditMax;

    }


    // GETTERS AND SETTERS -------------------
    public Money getCreditMax() {
        return STANDAR_CREDITMAX;
    }

    public void setCreditMax(Money creditMax) {
        this.STANDAR_CREDITMAX = creditMax;
    }
}


