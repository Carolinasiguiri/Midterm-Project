package com.ironhack.midtermProjectcsiguiri.controllers.impl;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.accounts.AccountBase;
import com.ironhack.midtermProjectcsiguiri.models.users.ThirdParty;
import com.ironhack.midtermProjectcsiguiri.repository.AccountBaseRepository;
import com.ironhack.midtermProjectcsiguiri.repository.AdminsRepository;
import com.ironhack.midtermProjectcsiguiri.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AdminsController {

    @Autowired
    private AdminsRepository adminsRepository;

    @Autowired
    private AccountBaseRepository accountBaseRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @PostMapping("/create-thirdparty")
    @ResponseStatus(HttpStatus.CREATED)
    public void creation(@AuthenticationPrincipal UserDetails userDetails,
                         @RequestBody String hashKey,
                         @RequestBody String name) throws Exception {

        if(adminsRepository.findById(Integer.parseInt(userDetails.getUsername())).isPresent()){

            ThirdParty newThirdParty = new ThirdParty(name, hashKey);
            thirdPartyRepository.save(newThirdParty);

        } else {

            throw new Exception("Ha ocurrido un error");

        }

    }


    @GetMapping("/consult-balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money consultBalance (@AuthenticationPrincipal UserDetails userDetails, @RequestParam Integer id) throws Exception {

        if(adminsRepository.findById(Integer.parseInt(userDetails.getUsername())).isPresent()) {

            return accountBaseRepository.findById(id).get().getBalance();

        } else {

            throw new Exception("No se ha podido encontrar la cuenta");

        }

    }


    @PostMapping("/consult-balance")
    @ResponseStatus(HttpStatus.OK)
    public void modifBalance (@AuthenticationPrincipal UserDetails userDetails, @RequestBody Integer id, @RequestBody Money balance) throws Exception {

        if(adminsRepository.findById(Integer.parseInt(userDetails.getUsername())).isPresent()) {

            accountBaseRepository.findById(id).get().setBalance(balance);

        } else {

            throw new Exception("No se ha podido encontrar la cuenta");

        }

    }

}
