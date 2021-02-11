package com.ironhack.midtermProjectcsiguiri.controllers.impl;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.users.ThirdParty;
import com.ironhack.midtermProjectcsiguiri.repository.AdminsRepository;
import com.ironhack.midtermProjectcsiguiri.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AdminsController {

    @Autowired
    private AdminsRepository adminsRepository;

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

}
