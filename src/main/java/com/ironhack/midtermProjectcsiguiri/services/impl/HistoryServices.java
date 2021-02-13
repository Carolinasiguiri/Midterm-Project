package com.ironhack.midtermProjectcsiguiri.services.impl;

import com.ironhack.midtermProjectcsiguiri.Money;
import com.ironhack.midtermProjectcsiguiri.models.History;
import com.ironhack.midtermProjectcsiguiri.models.accounts.AccountBase;
import com.ironhack.midtermProjectcsiguiri.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HistoryServices {

    @Autowired
    private HistoryRepository historyRepository;

    public void createHistory(String concept, Money balance, AccountBase accountStart, AccountBase accountEnd) {

        historyRepository.save(new History(concept, balance, accountStart, accountEnd));

    }

    public BigDecimal balanceMedia(Integer id){
        List<BigDecimal> list=  historyRepository.checkMedia(id);
        BigDecimal sum = new BigDecimal(0);

        for(int i = 0; i<list.size(); i++){

            sum.add(list.get(i));
            i++;

        }
        return sum;
    }

    public BigDecimal checkLast24hours(Integer id){

        List<BigDecimal> list=  historyRepository.checkLast24Hours(id);
        BigDecimal sum = new BigDecimal(0);

        for(int i = 0; i<list.size(); i++){

            sum.add(list.get(i));
            i++;

        }
        return sum;
    }

}
