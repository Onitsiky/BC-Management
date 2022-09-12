package com.example.bcmanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Balance {
  private Instant date;
  private Double montant;
}
