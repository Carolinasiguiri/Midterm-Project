package com.ironhack.midtermProjectcsiguiri.repository;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.History;
import com.ironhack.midtermProjectcsiguiri.models.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

    @Query("SELECT SUM(balance) FROM History WHERE date >= NOW() - INTERVAL 1 DAY")
    Money checkLast24Hours(Integer id);

    @Query("SELECT AVG(balance) from History")
    Money checkMedia(Integer id);

}
