package com.example.agcbiohardwareinventorysystembackend.Controller;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Service.AssetDisposalService;
import com.example.agcbiohardwareinventorysystembackend.Service.DisposedAssetItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
}
