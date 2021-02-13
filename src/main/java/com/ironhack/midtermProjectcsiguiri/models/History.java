package com.ironhack.midtermProjectcsiguiri.models;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.accounts.AccountBase;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String concept;
    private Date date;

    @AttributeOverrides({
            @AttributeOverride( name = "currency", column = @Column(name = "balance_currency")),
            @AttributeOverride( name = "amount", column = @Column(name = "balance_amount"))
    })
    @Embedded
    private Money balance;

    @ManyToOne
    private AccountBase accountStart;

    @ManyToOne
    private AccountBase accountEnd;



    public void History() {



    }


    public History(String concept, Money balance, AccountBase accountStart, AccountBase accountEnd) {
        this.concept = concept;
        this.balance = balance;
        this.accountStart = accountStart;
        this.accountEnd = accountEnd;
        this.date = new Date();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountBase getAccountStart() {
        return accountStart;
    }

    public void setAccountStart(AccountBase accountStart) {
        this.accountStart = accountStart;
    }

    public AccountBase getAccountEnd() {
        return accountEnd;
    }

    public void setAccountEnd(AccountBase accountEnd) {
        this.accountEnd = accountEnd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
