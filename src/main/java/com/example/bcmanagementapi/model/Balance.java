package com.example.bcmanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;


@Entity
@Table(name = "\"balance\"")
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Balance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date",nullable = false)
  private LocalDate date;

  @Column(name = "rest",nullable = false)
  private Double totalRest;

  @Transient
  private Double gain;
  @Transient
  private Double expenditure;
  @Transient
  private Double benefits;
  @Transient
  private Double lose;


}
