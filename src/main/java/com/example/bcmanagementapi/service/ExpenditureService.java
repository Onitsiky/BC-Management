package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Expenditure;
import com.example.bcmanagementapi.repository.ExpenditureRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenditureService {
  private final ExpenditureRepository expenditureRepository;

  public Expenditure getById (Long id){
    return expenditureRepository.findById(id).get();
  }

  public List<Expenditure> getAll (int page, int page_size){
    Pageable pageable = PageRequest.of(page, page_size);
    return expenditureRepository.findAll(pageable).toList();
  }


  public List<Expenditure> getList (){
    return expenditureRepository.findAll();
  }
  public List<Expenditure> save (List<Expenditure> expenditures){
    return expenditureRepository.saveAll(expenditures);
  }
}
