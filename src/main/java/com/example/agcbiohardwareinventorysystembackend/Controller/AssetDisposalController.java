package com.example.agcbiohardwareinventorysystembackend.Controller;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Service.AssetDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This notation is used to tell Spring that this class is a controller
@RestController
// This is used to allow cross origin requests from the frontend to the backend to be able to connect
@RequestMapping("/assetDisposal")
// This class is asset disposal controller class that handles all the requests for the asset disposal table
//in the database and returns the appropriate response to the frontend
public class AssetDisposalController {

    private final AssetDisposalService service;

    // This is used to tell Spring to inject the AssetDisposalService class into this class,
//so that we can use the methods in the AssetDisposalService class to perform CRUD operations on the asset disposal table in the database
    @Autowired
    public AssetDisposalController(AssetDisposalService service) {
        this.service = service;
    }

    // CREATE: Post request to add/create a new asset disposal record to the database
    @PostMapping
    public AssetDisposal add(@RequestBody AssetDisposal assetDisposal) {
        return service.save(assetDisposal);
    }

    // READ: Get request to get a single asset disposal record by ID
    // This method returns a response entity with the asset disposal record if it exists in the database and a not found response if it does not exist in the database
    @GetMapping("/{id}")
    public ResponseEntity<AssetDisposal> getById(@PathVariable int id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // This method returns a list of all the asset disposal records in the database
    //if there are any records in the database and an empty list if there are no records in the database
    @GetMapping
    public List<AssetDisposal> getAll() {
        return service.findAll();
    }

    // UPDATE: Update an existing asset disposal record
    // This method returns a response entity with the updated asset disposal record if it exists in the database and a not found response if it does not exist in the database
    @PutMapping("/{id}")
    public ResponseEntity<AssetDisposal> update(@PathVariable int id, @RequestBody AssetDisposal assetDisposal) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        assetDisposal.setId(id); // Ensure the ID is set to the asset disposal being updated
        return ResponseEntity.ok(service.save(assetDisposal));
    }

    // DELETE: Remove an asset disposal record
    // This method returns a response entity with an ok status if the asset disposal record was successfully deleted and a not found response if it does not exist in the database
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // This method moves an asset disposal item to the disposed table in the database
    @PostMapping("/transfer-to-disposed/{id}")
    //The question mark in the response entity is used to tell Spring that the response entity can be of any type
    public ResponseEntity<?> transferToDisposed(@PathVariable int id) {
        service.transferToDisposed(id);
        return ResponseEntity.ok().build();
    }


}