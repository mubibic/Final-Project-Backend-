package com.example.agcbiohardwareinventorysystembackend.Repository;

import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryInStockRepository extends JpaRepository<InventoryInStock, Integer> {
    List<InventoryInStock> findByType(String type);
    List<InventoryInStock> findByModel(String model);
    List<InventoryInStock> findByExtraInformation(String extraInformation);
    List<InventoryInStock> findByLocation(String location);
}
