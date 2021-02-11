package com.ironhack.midtermProjectcsiguiri.models.accounts;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.enums.Status;
import com.ironhack.midtermProjectcsiguiri.models.users.AccountHolders;
import com.ironhack.midtermProjectcsiguiri.models.users.Address;
import com.ironhack.midtermProjectcsiguiri.models.users.Users;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccountBaseTest {

    @Test
    void multar() {
        // (String name, Date birth, Address primaryAddress, Address mailingAddress)
        // (String address, int number, String country, String city)
        // (Money balance, Users primaryOwner, Users secondaryOwner, int secretKey, Status status)
        AccountHolders pepito = new AccountHolders
                ("pepito",
                new Date(1230, 12,31),
                new Address("calle sonrisas-felices", 9000, "Divertilandia", "Perritos calientes"),
                new Address("calle ironhackmadrid", 2, "Cola cola", "pesi pesi")
                );
        AccountHolders pepita = new AccountHolders
                ("pepita",
                        new Date(1230, 12,31),
                        new Address("calle sonrisas-tristes", 9000, "DivertiNOlandia", "Perritos frios"),
                        new Address("calle ironhackbarcelona", 2, "tónica", "Blue bull(te da aaaalas)")
                );

        AccountBase test1 = pepito.createChecking(new Money(new BigDecimal(300)), pepita, Status.ACTIVE, 1234);
        test1.setBalance(new Money(new BigDecimal(100)));
        assertEquals(true, new BigDecimal(60).equals(test1.getBalance().getAmount()));

    }
}