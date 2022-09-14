package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Balance;
import com.example.bcmanagementapi.model.Bill;
import com.example.bcmanagementapi.repository.BalanceRepository;
import com.example.bcmanagementapi.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BillService {
  private final BalanceRepository balanceRepository;
  private BillRepository billRepository;

  public Bill getBillById (Long id){
    return billRepository.findById(id).get();
  }

  public List<Bill> getAll (int page, int page_size){
    Pageable pageable = PageRequest.of(page, page_size);
    return billRepository.findAll(pageable).toList();
  }

  public List<Bill> getList (){
    return billRepository.findAll();
  }
  @Transactional
  public List<Bill> saveAll (List<Bill> toSave){
    for (Bill bill : toSave) {
      Balance balance;
      if(balanceRepository.findByDate(bill.getDate()) != null){
        balance = balanceRepository.findByDate(bill.getDate());
        balance.setTotalRest(balance.getTotalRest() + bill.getTotal());
        balanceRepository.save(balance);
      }
      else {
        balance = new Balance();
        balance.setDate(bill.getDate());
        if(balanceRepository.findByDateBefore(bill.getDate()) != null){
          balance.setTotalRest(balanceRepository.findByDateBefore(bill.getDate()).getTotalRest() + bill.getTotal());
          balanceRepository.save(balance);
        }
        else {
          balance.setTotalRest(0 + bill.getTotal());
          balanceRepository.save(balance);
        }
      }
    }
    return billRepository.saveAll(toSave);
  }
}
