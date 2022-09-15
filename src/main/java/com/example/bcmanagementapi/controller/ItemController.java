package com.example.bcmanagementapi.controller;

import com.example.bcmanagementapi.model.Item;
import com.example.bcmanagementapi.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ItemController {
  private final ItemService itemService;


  @GetMapping("/items/{id}")
  public Item getItemById (@PathVariable Long id){
    return itemService.getById(id);
  }

  @GetMapping("/items")
  public List<Item> getItems (
      @RequestParam int page,
      @RequestParam int page_size
  ){
    return itemService.getAll(page, page_size);
  }

  @PutMapping("/items")
  public List<Item> createOrUpdateItem (
      @RequestBody List<Item> items
  ){
    return itemService.saveItems(items);
  }
}
