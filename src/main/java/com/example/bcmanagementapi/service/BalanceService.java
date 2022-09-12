package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Bill;
import com.example.bcmanagementapi.model.Expenditure;
import com.example.bcmanagementapi.repository.BillRepository;
import com.example.bcmanagementapi.repository.ExpenditureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BalanceService {
  private final BillRepository billRepository;
  private final ExpenditureRepository expenditureRepository;

  public Double getBalance (LocalDate date){
    List<Bill> bills = billRepository.findAllByDate(date);
    List<Expenditure> expenditures = expenditureRepository.getExpenditureByDate(date);
    Double balance = 0d;
    for (Bill bill : bills) {
      balance = balance + bill.getTotal();
    }
    for (Expenditure expenditure : expenditures) {
      balance = balance - expenditure.getMontant();
    }
    return balance;
  }
}
