package com.example.bcmanagementapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Expenditures implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Float due;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ExpenditureCategory category;
}
