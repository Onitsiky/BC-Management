package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Category;
import com.example.bcmanagementapi.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
  private final CategoryRepository repository;

  public Category getById (Long id){
    return repository.findById(id).get();
  }

  public List<Category> getAll(int page, int page_size){
    Pageable pageable = PageRequest.of(page, page_size);
    return repository.findAll(pageable).toList();
  }

  public List<Category> saveAll(List<Category> categories){
    return repository.saveAll(categories);
  }
}
