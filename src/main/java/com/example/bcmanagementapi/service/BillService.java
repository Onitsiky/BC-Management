package com.example.bcmanagementapi.service;

import com.example.bcmanagementapi.model.Client;
import com.example.bcmanagementapi.model.mapper.BillCreate;
import com.example.bcmanagementapi.model.mapper.BillMapped;
import com.example.bcmanagementapi.model.Bill;
import com.example.bcmanagementapi.repository.BillRepository;
import com.example.bcmanagementapi.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillService {
    private final BillRepository billRepository;
    private final BillMapped billMapped;

    private final ClientRepository clientRepository;

    public List<Bill> getAll(int page, int page_size){
        Pageable pageable = PageRequest.of(page, page_size);
        return billRepository.findAll(pageable).toList();
    }
    public Bill createBill(BillCreate bill){
        Client exist = clientRepository.findByName(bill.getOwner());
        if(exist == null){
            Client temp = new Client();
            temp.setName(bill.getOwner());
            temp.setContact(bill.getContact());
            clientRepository.save(temp);
        }
        return billRepository.save(billMapped.toDomain(bill));
    }
}
