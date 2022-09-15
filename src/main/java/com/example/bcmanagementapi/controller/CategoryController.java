package com.example.bcmanagementapi.controller;

import com.example.bcmanagementapi.model.Category;
import com.example.bcmanagementapi.service.CategoryService;
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
public class CategoryController {
  private CategoryService categoryService;

  @GetMapping("/categories/{id}")
  public Category getCategoryById (@PathVariable Long id){
    return categoryService.getById(id);
  }

  @GetMapping("/categories")
  public List<Category> getCategory (
      @RequestParam int page,
      @RequestParam int page_size
  ){
    return categoryService.getAll(page,page_size);
  }

  @PutMapping("/categories")
  public List<Category> createOrUpdateCategories(
      @RequestBody List<Category> categories
  ){
    return categoryService.saveAll(categories);
  }
}
