package com.example.agcbiohardwareinventorysystembackend.Controller;

import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import com.example.agcbiohardwareinventorysystembackend.Service.InventoryInStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:8080")
@RequestMapping("/inventory")
public class InventoryInStockController {

    private final InventoryInStockService service;

    @Autowired
    public InventoryInStockController(InventoryInStockService service) {
        this.service = service;
    }

    // CREATE: Add a new inventory item
    @PostMapping("/items")
    public InventoryInStock add(@RequestBody InventoryInStock inventoryItem) {
        return service.save(inventoryItem);
    }

    // READ: Get a single inventory item by ID
    @GetMapping("/items/{id}")
    public ResponseEntity<InventoryInStock> getById(@PathVariable int id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // READ: Get all inventory items
    @GetMapping("/items")
    public List<InventoryInStock> getAll() {
        return service.findAll();
    }

    // UPDATE: Update an existing inventory item
    @PutMapping("/items/{id}")
    public ResponseEntity<InventoryInStock> update(@PathVariable int id, @RequestBody InventoryInStock inventoryItem) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        inventoryItem.setId(id);
        return ResponseEntity.ok(service.save(inventoryItem));
    }


    // DELETE: Remove an inventory item
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
