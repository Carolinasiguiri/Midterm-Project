package com.ironhack.midtermProjectcsiguiri.repository;

import com.ironhack.midtermProjectcsiguiri.models.users.Admins;
import com.ironhack.midtermProjectcsiguiri.models.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, Integer> {



}
