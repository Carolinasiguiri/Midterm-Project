package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.enums.Status;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
public class StudentChecking extends AccountBase{


    private int secretKey;

    @Enumerated(EnumType.STRING)
    private Status status;


    public StudentChecking() {



    }

    public StudentChecking(Status status, int secretKey) {
        this.status = status;
        this.secretKey = secretKey;
    }

    public StudentChecking(Money balance, Users primaryOwner, Users secondaryOwner, Status status, int secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.status = status;
        this.secretKey = secretKey;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(int secretKey) {
        this.secretKey = secretKey;
    }


}

