package com.ironhack.midtermProjectcsiguiri.repository;

import com.ironhack.midtermProjectcsiguiri.models.users.AccountHolders;
import com.ironhack.midtermProjectcsiguiri.models.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Integer> {
}
