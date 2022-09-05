package com.example.bcmanagementapi.endpoint.rest;

import com.example.bcmanagementapi.model.Item;
import com.example.bcmanagementapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/item")
@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @GetMapping
    private List<Item> getItems(){
        return itemRepository.findAll();
    }

    @PostMapping
    private String addItems(
            @RequestBody List<Item> items
    ){
        itemRepository.saveAll(items);
        return "Successfully added!";
    }
}
