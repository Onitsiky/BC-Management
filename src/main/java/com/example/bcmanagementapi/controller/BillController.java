package com.example.bcmanagementapi.controller;

import com.example.bcmanagementapi.model.mapper.BillMapper;
import com.example.bcmanagementapi.model.rest.Bill;
import com.example.bcmanagementapi.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class BillController {
  private BillMapper mapper;
  private BillService billService;

  @GetMapping("/bills/{id}")
  public Bill getBillById (@PathVariable Long id){
    return mapper.toRest(billService.getBillById(id));
  }

  @GetMapping("/bills")
  public List<com.example.bcmanagementapi.model.Bill> getBills (
      @RequestParam int page,
      @RequestParam int page_size
  ){
    return billService.getAll(page,page_size);
  }

  @PutMapping("/bills")
  public List<Bill> saveBills (
      @RequestBody List<Bill> bills
  ){
    List<com.example.bcmanagementapi.model.Bill> toSave = bills.stream().map(mapper :: toDomain)
        .collect(Collectors.toUnmodifiableList());
    return billService.saveAll(toSave)
        .stream().map(mapper :: toRest)
        .collect(Collectors.toUnmodifiableList());
  }
}
