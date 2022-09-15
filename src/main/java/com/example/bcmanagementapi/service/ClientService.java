package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Client;
import com.example.bcmanagementapi.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
  private final ClientRepository clientRepository;

  public Client getClientById (Long id){
    return clientRepository.findById(id).get();
  }

  public Client getClientByName (String name){
    return clientRepository.getClientByName(name);
  }
  public Client findByName (String name){
    return clientRepository.findByName(name);
  }

  public List<Client> getAll (
      int page, int page_size
  ){
    Pageable pageable = PageRequest.of(page, page_size, Sort.by(Sort.Direction.ASC,"id"));
    return clientRepository.findAll(pageable).toList();
  }

  public List<Client> saveClient (List<Client> clients){
    return clientRepository.saveAll(clients);
  }
}
