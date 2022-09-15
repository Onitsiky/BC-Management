package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Balance;
import com.example.bcmanagementapi.model.Bill;
import com.example.bcmanagementapi.model.Expenditure;
import com.example.bcmanagementapi.repository.BalanceRepository;
import com.example.bcmanagementapi.repository.BillRepository;
import com.example.bcmanagementapi.repository.ExpenditureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BalanceService {
  private final BalanceRepository balanceRepository;
  private final BillRepository billRepository;
  private final ExpenditureRepository expenditureRepository;


  public Balance getBalance (LocalDate date){
    Balance balance = balanceRepository.findByDate(date);
    List<Bill> bills = billRepository.findAllByDate(date);
    List<Expenditure> expenditures = expenditureRepository.getExpenditureByDate(date);
    Double temp = 0d;
    Double gain = 0d;
    Double expenditureAmount = 0d;
    for (Bill bill : bills) {
      gain = gain + bill.getTotal();
      temp = temp + bill.getTotal();
    }
    for (Expenditure expenditure : expenditures) {
      expenditureAmount = expenditureAmount + expenditure.getMontant();
      temp = temp - expenditure.getMontant();
    }
    balance.setGain(gain);
    balance.setExpenditure(expenditureAmount);
    if(temp >= 0){
      balance.setBenefits(temp);
      balance.setLose(0d);
    }
    else {
      balance.setBenefits(0d);
      balance.setLose(-temp);
    }
    return balance;
  }
}
