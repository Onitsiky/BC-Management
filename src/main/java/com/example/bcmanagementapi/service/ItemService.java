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
}
