package com.example.agcbiohardwareinventorysystembackend.Service;

import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Repository.DisposedAssetItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposedAssetItemsService {

    private final DisposedAssetItemsRepository dRepository;

    @Autowired
    public DisposedAssetItemsService(DisposedAssetItemsRepository dRepository) {
        this.dRepository = dRepository;
    }

    public List<DisposedAssetItems> findAll() {
        return dRepository.findAll();
    }
}
