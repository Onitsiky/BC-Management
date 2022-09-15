package com.example.bcmanagementapi.controller;

import com.example.bcmanagementapi.model.Expenditure;
import com.example.bcmanagementapi.service.ExpenditureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class ExpenditureController {
  private ExpenditureService expenditureService;

  @GetMapping("/expenditures/{id}")
  public Expenditure getExpenditureById (@PathVariable Long id){
    return expenditureService.getById(id);
  }

  @GetMapping("/expenditures")
  public List<Expenditure> getExpenditure (
      @RequestParam int page,
      @RequestParam int page_size
  ){
    return expenditureService.getAll(page, page_size);
  }

  @PutMapping("/expenditures")
  public List<Expenditure> createOrUpdateExpenditure(
      @RequestBody List<Expenditure> expenditures
  ){
    return expenditureService.save(expenditures);
  }
}
