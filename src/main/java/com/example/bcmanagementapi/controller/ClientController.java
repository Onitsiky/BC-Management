package com.example.bcmanagementapi.controller;

import com.example.bcmanagementapi.model.Client;
import com.example.bcmanagementapi.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController {
  private final ClientService clientService;

  @GetMapping("/clients/{id}")
  public Client getClientById (@PathVariable Long id){
    return clientService.getClientById(id);
  }

  @GetMapping("/clients")
  public List<Client> getClients(
      @RequestParam int page,
      @RequestParam int page_size){
    return clientService.getAll(page, page_size);
  }

  @PutMapping("/clients")
  public List<Client> saveClients (
      @RequestBody List<Client> clients
  ){
    return clientService.saveClient(clients);
  }

}
