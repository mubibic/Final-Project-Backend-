package com.example.agcbiohardwareinventorysystembackend.Service;

import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import com.example.agcbiohardwareinventorysystembackend.Repository.InventoryInStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryInStockService {

    private final InventoryInStockRepository repository;

    @Autowired
    public InventoryInStockService(InventoryInStockRepository repository) {
        this.repository = repository;
    }

    public InventoryInStock save(InventoryInStock inventoryItem) {
        return repository.save(inventoryItem);
    }

    public Optional<InventoryInStock> findById(int id) {
        return repository.findById(id);
    }

    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    public List<InventoryInStock> findAll() {
        return repository.findAll();
    }

    public InventoryInStock update(InventoryInStock inventoryItem) {
        return repository.save(inventoryItem); // Assuming you handle update logic via save
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    // Additional methods like search or custom logic can be added here
}
