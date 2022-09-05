package com.example.bcmanagementapi.Service;

import com.example.bcmanagementapi.Model.Bill;
import com.example.bcmanagementapi.Repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillService {
    private final BillRepository billRepository;

    public List<Bill> getAll(int page, int page_size){
        Pageable pageable = PageRequest.of(page, page_size);
        return billRepository.findAll(pageable).toList();
    }
    public String createBill(
            List<Bill> bills
    ){
        billRepository.saveAll(bills);
        return "Bills succesfully created" !
    }
}
