package com.example.bcmanagementapi.repository;

import com.example.bcmanagementapi.model.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {
  List<Expenditure> getExpenditureByDate(LocalDate date);
}
