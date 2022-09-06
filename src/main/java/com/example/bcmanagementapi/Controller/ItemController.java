package com.example.bcmanagementapi.Controller;

import com.example.bcmanagementapi.model.Item;
import com.example.bcmanagementapi.repository.ItemRepository;
import com.example.bcmanagementapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    public ItemRepository itemRepository;

    @Autowired
    public ItemService itemService;
    @GetMapping
    private List<Item> getItems(
            @RequestParam int page,
            @RequestParam int page_size
    ){
        return itemService.getItems(page, page_size).stream().toList();
    }

    @PostMapping
    public String addItems(
            @RequestBody List<Item> items
    ){
        itemRepository.saveAll(items);
        return "Items successfully added!";
    }

    @PutMapping
    public String updateItem(
            @RequestBody Item item
    ){
        return itemService.modifyItem(item);
    }
}
