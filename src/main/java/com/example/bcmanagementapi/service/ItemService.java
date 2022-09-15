package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Item;
import com.example.bcmanagementapi.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
  public final ItemRepository itemRepository;

  public Item getById (Long id){
    return itemRepository.findById(id).get();
  }

  public Item getByName (String name){
    return itemRepository.findByName(name);
  }

  public List<Item> getAll (int page, int page_size){
    Pageable pageable = PageRequest.of(page, page_size);
    return itemRepository.findAll(pageable).toList();
  }

  @Transactional
  public List<Item> saveItems (List<Item> items){
   List<Item> saved = itemRepository.saveAll(items);
   return saved;
  }
}
