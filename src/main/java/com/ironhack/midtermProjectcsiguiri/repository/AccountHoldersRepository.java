package com.ironhack.midtermProjectcsiguiri.repository;

import com.ironhack.midtermProjectcsiguiri.models.users.AccountHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHoldersRepository extends JpaRepository<AccountHolders, Integer> {



}
