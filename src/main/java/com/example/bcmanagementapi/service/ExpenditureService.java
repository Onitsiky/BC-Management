package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Balance;
import com.example.bcmanagementapi.model.Expenditure;
import com.example.bcmanagementapi.repository.BalanceRepository;
import com.example.bcmanagementapi.repository.ExpenditureRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenditureService {
  private final BalanceRepository balanceRepository;
  private final ExpenditureRepository expenditureRepository;

  public Expenditure getById (Long id){
    return expenditureRepository.findById(id).get();
  }

  public List<Expenditure> getAll (int page, int page_size){
    Pageable pageable = PageRequest.of(page, page_size, Sort.by(Sort.Direction.ASC,"id"));
    return expenditureRepository.findAll(pageable).toList();
  }


  public List<Expenditure> getList (){
    return expenditureRepository.findAll();
  }
  public List<Expenditure> save (List<Expenditure> expenditures){
    for (Expenditure expenditure : expenditures) {
      Balance balance;
      if(balanceRepository.findByDate(expenditure.getDate()) != null){
        balance = balanceRepository.findByDate(expenditure.getDate());
        balance.setTotalRest(balance.getTotalRest() - expenditure.getMontant());
        balanceRepository.save(balance);
      }
      else {
        balance = new Balance();
        balance.setDate(expenditure.getDate());
        if(balanceRepository.findByDateBefore(expenditure.getDate()) != null){
          balance.setTotalRest(balanceRepository.findByDateBefore(expenditure.getDate()).getTotalRest() + expenditure.getMontant());
          balanceRepository.save(balance);
        }
        else {
          balance.setTotalRest(0 - expenditure.getMontant());
          balanceRepository.save(balance);
        }
      }
    }
    return expenditureRepository.saveAll(expenditures);
  }
}
