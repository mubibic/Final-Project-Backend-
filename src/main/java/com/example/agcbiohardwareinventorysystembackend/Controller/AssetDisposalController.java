package com.example.agcbiohardwareinventorysystembackend.Controller;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Service.AssetDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assetDisposal")
public class AssetDisposalController {

    private final AssetDisposalService service;

    @Autowired
    public AssetDisposalController(AssetDisposalService service) {
        this.service = service;
    }

    // CREATE: Add a new asset disposal record
    @PostMapping
    public AssetDisposal add(@RequestBody AssetDisposal assetDisposal) {
        return service.save(assetDisposal);
    }

    // READ: Get a single asset disposal record by ID
    @GetMapping("/{id}")
    public ResponseEntity<AssetDisposal> getById(@PathVariable int id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // READ: Get all asset disposal records
    @GetMapping
    public List<AssetDisposal> getAll() {
        return service.findAll();
    }

    // UPDATE: Update an existing asset disposal record
    @PutMapping("/{id}")
    public ResponseEntity<AssetDisposal> update(@PathVariable int id, @RequestBody AssetDisposal assetDisposal) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        assetDisposal.setId(id); // Ensure the ID is set to the asset disposal being updated
        return ResponseEntity.ok(service.save(assetDisposal));
    }

    // DELETE: Remove an asset disposal record
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
