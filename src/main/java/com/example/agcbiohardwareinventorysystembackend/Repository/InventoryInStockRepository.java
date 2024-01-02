package com.example.agcbiohardwareinventorysystembackend.Repository;

import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// This interface is for the InventoryInStockRepository which extends the JpaRepository interface to perform
// CRUD operations on the InventoryInStock entity in the database using the methods provided by the JpaRepository interface

// This annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects

@Repository
public interface InventoryInStockRepository extends JpaRepository<InventoryInStock, Integer> {
    // These methods are used to find inventory items by their attributes
    List<InventoryInStock> findByType(String type);
    List<InventoryInStock> findByModel(String model);
    List<InventoryInStock> findByExtraInformation(String extraInformation);
    List<InventoryInStock> findByLocation(String location);
    InventoryInStock findByTypeAndModelAndExtraInformationAndLocation(String type, String model, String extraInformation, String location);
}
