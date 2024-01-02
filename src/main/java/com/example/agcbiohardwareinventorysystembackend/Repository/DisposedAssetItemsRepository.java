package com.example.agcbiohardwareinventorysystembackend.Repository;

import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Entity.InventoryInStock;
import com.example.agcbiohardwareinventorysystembackend.Service.DisposedAssetItemsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// This interface is for the DisposedAssetItemsRepository which extends the JpaRepository interface to perform
// CRUD operations on the DisposedAssetItems entity in the database using the methods provided by the JpaRepository interface

// This annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects

@Repository
public interface DisposedAssetItemsRepository extends JpaRepository<DisposedAssetItems, Integer> {
    // These methods are used to find disposed asset items by their attributes
    List<DisposedAssetItems> findByType(String type);

    List<DisposedAssetItems> findBySerialNumber(String model);

    List<DisposedAssetItems> findByExtraInformation(String extraInformation);

    List<DisposedAssetItems> findByDisposalDate(String disposalDate);

    List<DisposedAssetItems> findByDisposalReason(String disposalReason);
}
