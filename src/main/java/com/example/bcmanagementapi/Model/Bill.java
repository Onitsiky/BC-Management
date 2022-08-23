package com.example.bcmanagementapi.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client owner;

    @JoinColumn
    @OneToMany
    private List<OrderItem> orders;
}
