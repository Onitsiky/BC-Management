package com.example.bcmanagementapi.endpoint.mapper;

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
    private List<String> items;
}
