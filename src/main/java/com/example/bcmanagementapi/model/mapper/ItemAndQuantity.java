package com.example.bcmanagementapi.model.mapper;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemAndQuantity {
    private String item;
    private Integer quantity;
}
