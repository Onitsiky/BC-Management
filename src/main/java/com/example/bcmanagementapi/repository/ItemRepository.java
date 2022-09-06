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

}