package com.example.bcmanagementapi.endpoint.rest;

import com.example.bcmanagementapi.endpoint.mapper.BillCreate;
import com.example.bcmanagementapi.model.Bill;
import com.example.bcmanagementapi.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class BillController {

    @Autowired
    private final BillService billService;

    @GetMapping("/")
    public String checkHealth(){
        return "Pong";
    }

    @GetMapping("/bills")
    public List<Bill> getBills(
            @RequestParam int page,
            @RequestParam int page_size
            ){
        return billService.getAll(page, page_size);
    }

    @PostMapping("/bills")
    public Bill createBills(
            @RequestBody BillCreate bill
    ){
        return billService.createBill(bill);
    }
}
