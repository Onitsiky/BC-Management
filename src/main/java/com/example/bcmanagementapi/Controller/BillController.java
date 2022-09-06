package com.example.bcmanagementapi.Controller;

import com.example.bcmanagementapi.model.mapper.BillCreate;
import com.example.bcmanagementapi.model.Bill;
import com.example.bcmanagementapi.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
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
    public String createBills(
            @RequestBody BillCreate bill
    ){
        billService.createBill(bill);
        return "Bill succefully created !";
    }
}
