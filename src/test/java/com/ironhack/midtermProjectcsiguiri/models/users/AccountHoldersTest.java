package com.ironhack.midtermProjectcsiguiri.models.users;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.enums.Status;
import com.ironhack.midtermProjectcsiguiri.models.accounts.AccountBase;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccountHoldersTest {

    @Test
    void createChecking() {

        AccountHolders pepita = new AccountHolders
                ("pepita",
                        new Date(1230, 12,31),
                        new Address("calle sonrisas-tristes", 9000, "DivertiNOlandia", "Perritos frios"),
                        new Address("calle ironhackbarcelona", 2, "tónica", "Blue bull(te da aaaalas)")
                );

        AccountBase test1 = pepita.createChecking(new Money(new BigDecimal(300)), pepita, Status.ACTIVE, 1234);

         assertEquals("Checking", test1.getClass());

        AccountHolders pepito = new AccountHolders
                ("pepita",
                        new Date(2000, 12,31),
                        new Address("calle sonrisas-tristes", 9000, "DivertiNOlandia", "Perritos frios"),
                        new Address("calle ironhackbarcelona", 2, "tónica", "Blue bull(te da aaaalas)")
                );


    }
}