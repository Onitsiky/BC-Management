package com.example.bcmanagementapi.controller;

import com.example.bcmanagementapi.model.Balance;
import com.example.bcmanagementapi.service.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class BalanceController {
  private BalanceService balanceService;

  @GetMapping("/balance")
  public Balance getBalance (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
    return balanceService.getBalance(date);
  }
}
