package com.example.agcbiohardwareinventorysystembackend.Repository;

import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryInStockRepository extends JpaRepository<InventoryInStock, Integer> {
    // Custom query methods can be added here if needed
}
