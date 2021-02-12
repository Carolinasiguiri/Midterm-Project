package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.enums.Status;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import com.ironhack.midtermProjectcsiguiri.repository.HistoryRepository;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

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



    public boolean checkInSeg() {

        Date checkDate = getLastTransaction();

        checkDate.setHours(checkDate.getSeconds()+1);

        if(checkDate.compareTo(new Date()) == 1 ){

            return true;

        }

        return false;

    }

    @Autowired
    private HistoryRepository historyRepository;
    public boolean chekIn24Hours(){

        if(historyRepository.checkLast24Hours(getId()).getAmount().compareTo(
                historyRepository.checkMedia(getId()).getAmount().multiply(new BigDecimal(1.5)))==1){

            return true;

        }

        return false;

    }

    public void checkFraud(){
        if(checkInSeg() || chekIn24Hours()){
            setStatus(Status.FROZEN);
        }
    }

}

