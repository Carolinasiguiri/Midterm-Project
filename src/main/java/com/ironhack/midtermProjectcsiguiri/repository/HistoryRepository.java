package com.ironhack.midtermProjectcsiguiri.repository;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.History;
import com.ironhack.midtermProjectcsiguiri.models.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

    @Query("SELECT balance FROM History WHERE date between dateadd(hour, -24, CURRENT_TIMESTAMP) AND CURRENT_TIMESTAMP")
    List<BigDecimal> checkLast24Hours(Integer id);

    @Query("SELECT balance from History")
    List<BigDecimal> checkMedia(Integer id);

}
