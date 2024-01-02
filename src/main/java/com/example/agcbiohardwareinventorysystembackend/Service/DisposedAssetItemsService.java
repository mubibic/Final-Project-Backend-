package com.example.agcbiohardwareinventorysystembackend.Service;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Repository.AssetDisposalRepository;
import com.example.agcbiohardwareinventorysystembackend.Repository.DisposedAssetItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// This service class is used to perform CRUD operations on the disposed_asset_items table in the database
// and to filter disposed asset items

// @Service annotation is used to mark the class as a service class, which means that it will be used to perform
// business logic operations in the application layer, and it is used to perform CRUD operations
// on the database tables using the repository classes
@Service
public class DisposedAssetItemsService {

    private final DisposedAssetItemsRepository dRepository;
    private final AssetDisposalRepository repository;

    // This annotation is used to inject the DisposedAssetItemsRepository instance and the AssetDisposalRepository instance into the DisposedAssetItemsService class
    @Autowired
    public DisposedAssetItemsService(DisposedAssetItemsRepository dRepository, AssetDisposalRepository repository) {
        this.dRepository = dRepository;
        this.repository = repository;
    }

    // This method is to filter disposed asset items by the given parameters and return the filtered list of disposed asset items
    public List<DisposedAssetItems> filterItems(String type, String serialNumber, String extraInformation, String disposalDate, String disposalReason) {
        if (type != null && !type.isEmpty()) {
            return dRepository.findByType(type);
        } else if (serialNumber != null && !serialNumber.isEmpty()) {
            return dRepository.findBySerialNumber(serialNumber);
        } else if (extraInformation != null && !extraInformation.isEmpty()) {
            return dRepository.findByExtraInformation(extraInformation);
        } else if (disposalDate != null && !disposalDate.isEmpty()) {
            return dRepository.findByDisposalDate(disposalDate);
        } else if (disposalReason != null && !disposalReason.isEmpty()) {
            return dRepository.findByDisposalReason(disposalReason);
        } else {
            return dRepository.findAll();
        }
    }

    public List<DisposedAssetItems> findAll() {
        return dRepository.findAll();
    }

    // This method is used to transfer a disposed asset item from the disposed_asset_items table to the asset_disposal table
    public void transferBackFromDisposed(int disposedAssetItemId) {
        DisposedAssetItems disposedItem = dRepository.findById(disposedAssetItemId)
                .orElseThrow(() -> new RuntimeException("Disposed asset not found"));

        AssetDisposal assetDisposal = convertToAssetDisposal(disposedItem);

        repository.save(assetDisposal);
        dRepository.deleteById(disposedAssetItemId);
    }

    // This method is used to convert a disposed asset item from the disposed_asset_items table to the asset_disposal table
    private AssetDisposal convertToAssetDisposal(DisposedAssetItems disposedItem) {
        AssetDisposal assetDisposal = new AssetDisposal();

        // Map fields from DisposedAssetItems to AssetDisposal
        assetDisposal.setType(disposedItem.getType());
        assetDisposal.setSerialNumber(disposedItem.getSerialNumber());
        assetDisposal.setExtraInformation(disposedItem.getExtraInformation());
        assetDisposal.setDisposalDate(disposedItem.getDisposalDate());
        assetDisposal.setDisposalReason(disposedItem.getDisposalReason());
        // Add any other fields that are common between the two entities

        return assetDisposal;
    }
}
