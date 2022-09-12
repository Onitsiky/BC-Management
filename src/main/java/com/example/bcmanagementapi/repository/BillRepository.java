package com.example.bcmanagementapi.repository;

import com.example.bcmanagementapi.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
  List<Bill> findAllByDate(LocalDate date);
}
