package com.example.bcmanagementapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode
@Data
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double unitPrice;

    @Column(nullable = false, columnDefinition = "Integer default 1")
    private Integer quantity;

}