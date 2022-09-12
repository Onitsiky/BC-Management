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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "\"bill\"")
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Bill {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private Client owner;

  @ManyToMany
  @JoinTable(
      name = "Bill_Item",
      joinColumns = @JoinColumn(name = "bill_id"),
      inverseJoinColumns = @JoinColumn(name = "item_id")
  )
  private List<Item> items;

  @Transient
  private Double total;

  @Column(nullable = false)
  private Boolean paid;

  public Double getTotal() {
    Double sum = 0d;
    for (Item item : items) {
      sum = sum + item.getUnitPrice();
    }
    return this.total = sum;
  }
}
