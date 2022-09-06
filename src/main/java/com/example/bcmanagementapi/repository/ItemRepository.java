package com.example.bcmanagementapi.repository;

import com.example.bcmanagementapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    public Item findByName(String name);

    public Optional<Item> findById(Long id);

    @Query("UPDATE Item c SET c.name = ?1, c.quantity= ?2, c.unitPrice= ?3 where c.id= ?4")
    public void updateItem(String name, Integer quantity, Double unitPrice, Long id);
}