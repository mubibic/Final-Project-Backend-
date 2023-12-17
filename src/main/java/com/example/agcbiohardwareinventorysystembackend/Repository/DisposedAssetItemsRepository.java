package com.example.agcbiohardwareinventorysystembackend.Repository;

import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import com.example.agcbiohardwareinventorysystembackend.Service.DisposedAssetItemsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisposedAssetItemsRepository extends JpaRepository<DisposedAssetItems, Integer> {
    List<DisposedAssetItems> findByType(String type);
    List<DisposedAssetItems> findBySerialNumber(String model);
    List<DisposedAssetItems> findByExtraInformation(String extraInformation);
    List<DisposedAssetItems> findByDisposalDate(String disposalDate);
    List<DisposedAssetItems> findByDisposalReason(String disposalReason);
}
