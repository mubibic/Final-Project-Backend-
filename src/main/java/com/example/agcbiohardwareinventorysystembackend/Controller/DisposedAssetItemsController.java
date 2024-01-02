package com.example.agcbiohardwareinventorysystembackend.Controller;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import com.example.agcbiohardwareinventorysystembackend.Service.AssetDisposalService;
import com.example.agcbiohardwareinventorysystembackend.Service.DisposedAssetItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// This annotation defines the base URL(endpoint) for all the requests in this controller
@RequestMapping("/disposed-items")
public class DisposedAssetItemsController {

    private final DisposedAssetItemsService service;

    @Autowired
    public DisposedAssetItemsController(DisposedAssetItemsService service) {
        this.service = service;
    }

    @GetMapping
    public List<DisposedAssetItems> getAll() {
        return service.findAll();
    }

    @PostMapping("/transfer-back-from-disposed/{id}")
    public ResponseEntity<?> transferBackFromDisposed(@PathVariable int id) {
        service.transferBackFromDisposed(id);
        return ResponseEntity.ok().build();
    }

    // This method is for getting the filtered list of disposed items from the database based on the parameters passed in the request URL from the frontend to the backend and returns the filtered list of disposed items to the frontend as a response
    @GetMapping("/items/filter")
    public List<DisposedAssetItems> filterItems(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String serialNumber,
            @RequestParam(required = false) String extraInformation,
            @RequestParam(required = false) String disposalDate,
            @RequestParam(required = false) String disposalReason) {
        return service.filterItems(type, serialNumber, extraInformation, disposalDate, disposalReason);
    }

}
