package com.example.bcmanagementapi.model.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class BillCreate {
    private String owner;
    private String contact;
    private List<ItemAndQuantity> items;
}
