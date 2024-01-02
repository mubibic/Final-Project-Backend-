package com.example.agcbiohardwareinventorysystembackend.Service;

import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import com.example.agcbiohardwareinventorysystembackend.Repository.InventoryInStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// This service class is used to perform CRUD operations on the inventory_in_stock table in the database
// and to filter inventory items

// @Service annotation is used to mark the class as a service class, which means that it will be used to perform
// business logic operations in the application layer, and it is used to perform CRUD operations

@Service
public class InventoryInStockService {

    private final InventoryInStockRepository repository;

    // This annotation is used to inject the InventoryInStockRepository instance into the InventoryInStockService class
    @Autowired
    public InventoryInStockService(InventoryInStockRepository repository) {
        this.repository = repository;
    }

    // This method is to filter inventory items by the given parameters and return the filtered list of inventory items
    public List<InventoryInStock> filterItems(String type, String model, String extraInformation, String location) {
        if (type != null && !type.isEmpty()) {
            return repository.findByType(type);
        } else if (model != null && !model.isEmpty()) {
            return repository.findByModel(model);
        } else if (extraInformation != null && !extraInformation.isEmpty()) {
            return repository.findByExtraInformation(extraInformation);
        } else if (location != null && !location.isEmpty()) {
            return repository.findByLocation(location);
        } else {
            return repository.findAll();
        }
    }

    // This method is used to save an inventory item in the inventory_in_stock table in the database
    public InventoryInStock save(InventoryInStock inventoryItem) {
        // This statement checks if the item exists in the database by checking the parameters respectively
        // and if it exists, it adds the quantity of the item to the existing quantity of the item in the database
        InventoryInStock existingItem = repository.findByTypeAndModelAndExtraInformationAndLocation(inventoryItem.getType(), inventoryItem.getModel(), inventoryItem.getExtraInformation(), inventoryItem.getLocation());
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + inventoryItem.getQuantity());
            return repository.save(existingItem);
        } else {
            //System.out.println("This item does not exist in DB");
            return repository.save(inventoryItem);
        }
    }

    // This method is used to get an inventory item by its ID
    //Optional means that the method will return an optional object of type InventoryInStock
    public Optional<InventoryInStock> findById(int id) {
        return repository.findById(id);
    }

    // This method is used to check if an inventory item exists in the database by its ID
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    // This method is used to get all inventory items from the database
    public List<InventoryInStock> findAll() {
        return repository.findAll();
    }

    // This a redundant method, it would update an existing inventory item in the database
    public InventoryInStock update(InventoryInStock inventoryItem) {
        return repository.save(inventoryItem); // Assuming you handle update logic via save
    }

    // This method is used to delete an inventory item from the database by its ID
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
