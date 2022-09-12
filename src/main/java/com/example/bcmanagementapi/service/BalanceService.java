package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Bill;
import com.example.bcmanagementapi.model.Expenditure;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BalanceService {
  private final BillService billService;
  private final ExpenditureService expenditureService;

  public Double getBalance (){
    List<Bill> bills = billService.getList();
    List<Expenditure> expenditures = expenditureService.getList();
    return null;
  }
}
