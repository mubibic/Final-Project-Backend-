package com.example.agcbiohardwareinventorysystembackend.Controller;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Service.AssetDisposalService;
import com.example.agcbiohardwareinventorysystembackend.Service.DisposedAssetItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
