package com.example.bcmanagementapi.model.mapper;

import com.example.bcmanagementapi.model.Client;
import com.example.bcmanagementapi.model.Item;
import com.example.bcmanagementapi.model.rest.Bill;
import com.example.bcmanagementapi.service.BillService;
import com.example.bcmanagementapi.service.ClientService;
import com.example.bcmanagementapi.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class BillMapper {
  private final ClientService clientService;

  private final ItemService itemService;

  public Bill toRest (com.example.bcmanagementapi.model.Bill domain){
    Bill bill = new Bill();
    bill.setOwner(domain.getOwner().getName());
    bill.setContact(domain.getOwner().getContact());
    List<Item> item = domain.getItems();
    List<String> items = new ArrayList<>();
    for (Item item1 : item) {
      items.add(item1.getName());
    }
    bill.setItem(items);
    return bill;
  }
  public com.example.bcmanagementapi.model.Bill toDomain (Bill rest){
    com.example.bcmanagementapi.model.Bill bill = new com.example.bcmanagementapi.model.Bill();
    Client owner = clientService.findByName(rest.getOwner());
    if(owner != null){
      bill.setOwner(owner);
    }
    else {
      Client client = new Client();
      client.setName(rest.getOwner());
      client.setContact(rest.getContact());
      clientService.saveClient(List.of(client));
      bill.setOwner(client);
    }
    List<Item> items = new ArrayList<>();
    for (String s : rest.getItem()) {
      items.add(itemService.getByName(s));
    }
    bill.setItems(items);
    bill.setPaid(false);
    bill.setDate(LocalDate.now());
    return bill;
  }
}
