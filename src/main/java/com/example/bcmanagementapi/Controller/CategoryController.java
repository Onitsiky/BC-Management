package com.example.bcmanagementapi.Controller;

import com.example.bcmanagementapi.model.Category;
import com.example.bcmanagementapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getCategories(){
        return categoryRepository.findAll().stream().toList();
    }

    @PostMapping
    public String addCategory(
            @RequestBody List<Category> categories
    ){
         categoryRepository.saveAll(categories);
         return "Categories added";
    }
    @PutMapping
    public String updateCategory(
            @RequestBody Category category
    ){
        categoryRepository.save(category);
        return "Category updated";
    }

}
