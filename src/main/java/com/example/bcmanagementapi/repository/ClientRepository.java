package com.example.bcmanagementapi.repository;

import com.example.bcmanagementapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
   Client getClientByName(String name);
   Client findByName(String name);
}
