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
    @Transient
    private Money creditMax;


    // EMPTY CONSTRUCTOR ---------------------
    public CreditCard() {

    }


    // CONSTRUCTOR ---------------------------
    public CreditCard(Money creditMax) {
        this.creditMax = creditMax;
    }

    public CreditCard(Money balance, Users primaryOwner, Users secondaryOwner, Double penaltyFee, Money creditMax) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.creditMax = creditMax;
    }


    // GETTERS AND SETTERS -------------------
    public Money getCreditMax() {
        return creditMax;
    }

    public void setCreditMax(Money creditMax) {
        this.creditMax = creditMax;
    }
}


