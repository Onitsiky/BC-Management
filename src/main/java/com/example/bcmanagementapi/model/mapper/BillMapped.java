package com.example.bcmanagementapi.endpoint.mapper;

import com.example.bcmanagementapi.model.Bill;
import com.example.bcmanagementapi.model.Client;
import com.example.bcmanagementapi.model.Item;
import com.example.bcmanagementapi.repository.ClientRepository;
import com.example.bcmanagementapi.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

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
        for (String item : billCreate.getItems()){
            Item temp = itemRepository.findByName(item);
            itemList.add(temp);
        }
        domainBill.setItems(itemList);
        return domainBill;
    }
}
