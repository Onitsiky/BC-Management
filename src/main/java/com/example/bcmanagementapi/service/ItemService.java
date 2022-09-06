package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Item;
import com.example.bcmanagementapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems(
            int page, int page_size
    ){
        Pageable pageable = PageRequest.of(page, page_size);
        return itemRepository.findAll(pageable).toList();
    }

    public String modifyItem(Item item){
        Optional<Item> exist = itemRepository.findById(item.getId());
        if(exist.isPresent()){
            itemRepository.updateItem(item.getName(), item.getQuantity(), item.getUnitPrice(), item.getId());
            return "Item successfully updated!";
        }
        else {
            itemRepository.save(item);
            return "Item successfully updated!";
        }
    }
}
