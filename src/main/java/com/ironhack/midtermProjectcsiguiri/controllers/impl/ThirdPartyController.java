package com.ironhack.midtermProjectcsiguiri.controllers.impl;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.accounts.AccountBase;
import com.ironhack.midtermProjectcsiguiri.models.users.ThirdParty;
import com.ironhack.midtermProjectcsiguiri.repository.AccountBaseRepository;
import com.ironhack.midtermProjectcsiguiri.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ThirdPartyController {

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private AccountBaseRepository accountBaseRepository;

    @PutMapping("/balance-transfer")
    @ResponseStatus(HttpStatus.OK)
    public void tranfersOut(@AuthenticationPrincipal UserDetails userDetails,
                            @RequestBody Money balance,
                            @RequestBody Integer start_id,
                            @RequestBody Integer end_id,
                            @RequestBody String hashKey) throws Exception {

        Optional<AccountBase> start = accountBaseRepository.findById(start_id);
        Optional<AccountBase> end = accountBaseRepository.findById(end_id);

        Optional<ThirdParty> userThirdParty = thirdPartyRepository.findById(start.get().getPrimaryOwner().getId());

        if(start.get().getPrimaryOwner().getName().equals(userDetails.getUsername())
                && userThirdParty.get().getHashKey().equals(hashKey)) {

            start.get().setBalance(new Money(start.get().getBalance().decreaseAmount(balance)));
            end.get().setBalance(new Money(start.get().getBalance().increaseAmount(balance)));

        }

    }



}
