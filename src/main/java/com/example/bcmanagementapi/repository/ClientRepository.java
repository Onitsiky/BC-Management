package com.example.bcmanagementapi.Repository;

import com.example.bcmanagementapi.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findByName(String name);
}
