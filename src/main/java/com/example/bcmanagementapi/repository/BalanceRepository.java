package com.example.bcmanagementapi.repository;

import com.example.bcmanagementapi.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
  Balance findByDate(LocalDate date);
  Balance findByDateBefore(LocalDate date);
}
