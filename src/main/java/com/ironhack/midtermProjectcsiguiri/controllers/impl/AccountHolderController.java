package com.ironhack.midtermProjectcsiguiri.controllers.impl;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.accounts.AccountBase;
import com.ironhack.midtermProjectcsiguiri.models.users.AccountHolders;
import com.ironhack.midtermProjectcsiguiri.repository.AccountBaseRepository;
import com.ironhack.midtermProjectcsiguiri.repository.AccountHoldersRepository;
import com.ironhack.midtermProjectcsiguiri.services.interfaces.IAccountHoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountHolderController {

    @Autowired
    private AccountBaseRepository accountBaseRepository;

    @Autowired
    private IAccountHoldersService iAccountHoldersService;

    @GetMapping("/account-balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money findById(@AuthenticationPrincipal UserDetails userDetails, @RequestParam Integer id) throws Exception {

        if(userDetails.getUsername().equals(accountBaseRepository.findById(id).get().getPrimaryOwner().getId())) {

            return accountBaseRepository.findById(id).get().getBalance();

        }

        throw new Exception("No puedes realizar esa operación");

    }

    @PatchMapping("/balance-transfer")
    @ResponseStatus(HttpStatus.OK)
    public void tranferUsers(@AuthenticationPrincipal UserDetails userDetails,
                         @RequestBody Integer id_start,
                         @RequestBody Money balance,
                         @RequestBody Integer id_end) throws Exception {

        if(userDetails.getUsername().equals(accountBaseRepository.findById(id_start).get().getPrimaryOwner().getName())
           ||
           userDetails.getUsername().equals(accountBaseRepository.findById(id_start).get().getSecondaryOwner().getName())) {

            Optional<AccountBase> start = accountBaseRepository.findById(id_start);
            Optional<AccountBase> end = accountBaseRepository.findById(id_end);

            if(start.get().getBalance().getAmount().compareTo(balance.getAmount()) == -1) {

                start.get().setBalance(new Money(start.get().getBalance().decreaseAmount(balance)));
                end.get().setBalance(new Money(start.get().getBalance().increaseAmount(balance)));

            } else {

                throw new Exception("No tienes fondos suficientes");

            }

        } else {

            throw new Exception("No puedes realizar esa operación");

        }

    }


}
