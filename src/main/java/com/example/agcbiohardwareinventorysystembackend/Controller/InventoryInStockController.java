package com.example.agcbiohardwareinventorysystembackend.Controller;

import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import com.example.agcbiohardwareinventorysystembackend.Service.InventoryInStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This annotation is used to tell Spring that this class is a controller
@RestController
// This annotation is used to allow cross-origin requests from the frontend to the backend
@CrossOrigin(origins = "*")
// This annotation defines the base URL for all the requests in this controller
@RequestMapping("/inventory")
public class InventoryInStockController {

    private final InventoryInStockService service;

    // This is used to tell Spring to inject the InventoryInStockService class into this class,
    // so that we can use the methods in the InventoryInStockService class to perform CRUD operations on the inventory table in the database
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

    // This method is for getting the filtered list of inventory items from the database based on the parameters
    // passed in the request URL from the frontend to the backend and returns the filtered list of inventory items to the frontend as a response
    // The RequestParam annotation is used to get the parameters passed in the request URL
    @GetMapping("/items/filter")
    public List<InventoryInStock> filterItems(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String extraInformation,
            @RequestParam(required = false) String location) {
        return service.filterItems(type, model, extraInformation, location);
    }


}
