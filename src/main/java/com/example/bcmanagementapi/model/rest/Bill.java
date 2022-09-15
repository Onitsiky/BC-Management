package com.example.bcmanagementapi.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
  private String owner;
  private String contact;
  private List<String> item;
}
