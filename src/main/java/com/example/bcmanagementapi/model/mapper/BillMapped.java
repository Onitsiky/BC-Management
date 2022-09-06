package com.example.bcmanagementapi.model.mapper;

import com.example.bcmanagementapi.model.Bill;
import com.example.bcmanagementapi.model.Item;
import com.example.bcmanagementapi.repository.ClientRepository;
import com.example.bcmanagementapi.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Component
public class BillMapped {

    private ClientRepository clientRepository;
    private ItemRepository itemRepository;

    public Bill toDomain(BillCreate billCreate){
        Bill domainBill = new Bill();
        domainBill.setClient(clientRepository.findByName(billCreate.getOwner()));
        List<Item> itemList = new ArrayList<>();
        for(ItemAndQuantity s : billCreate.getItems()){
            Item temp = itemRepository.findByName(s.getItem());
            if(temp.getQuantity() >= s.getQuantity()){
                itemList.add(temp);
            }
        }
        domainBill.setItems(itemList);
        return domainBill;
    }
}
