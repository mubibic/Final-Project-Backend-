package com.example.agcbiohardwareinventorysystembackend.Service;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Repository.AssetDisposalRepository;
import com.example.agcbiohardwareinventorysystembackend.Repository.DisposedAssetItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// This service class is used to perform CRUD operations on the asset_disposal table in the database
// and to transfer items to disposed_asset_items table

// @Service annotation is used to mark the class as a service class, which means that it will be used to perform
// business logic operations in the application layer, and it is used to perform CRUD operations
// on the database tables using the repository classes
@Service
public class AssetDisposalService {

    private final AssetDisposalRepository repository;
    private final DisposedAssetItemsRepository dRepository;

    // This annotation is used to inject the AssetDisposalRepository instance and the DisposedAssetItemsRepository instance
    // into the AssetDisposalService class
    @Autowired
    public AssetDisposalService(AssetDisposalRepository repository, DisposedAssetItemsRepository dRepository) {
        this.repository = repository;
        this.dRepository = dRepository;
    }

    // This method is used to save an asset disposal item in the asset_disposal table in the database
    public AssetDisposal save(AssetDisposal assetDisposal) {
        return repository.save(assetDisposal);
    }

    //This method is used to retrieve an asset disposal item from the asset_disposal table in the database
    public Optional<AssetDisposal> findById(int id) {
        return repository.findById(id);
    }

    // This method is used to check if an asset disposal item exists in the asset_disposal table in the database
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    // This method is used to retrieve all asset disposal items from the asset_disposal table in the database
    public List<AssetDisposal> findAll() {
        return repository.findAll();
    }

    // This method is used to update an asset disposal item in the asset_disposal table in the database
    public AssetDisposal update(AssetDisposal assetDisposal) {
        return repository.save(assetDisposal);
    }

    // This method is used to delete an asset disposal item from the asset_disposal table in the database
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    // This method is used to transfer an asset disposal item from the asset_disposal table to the disposed_asset_items table
    public void transferToDisposed(int assetDisposalId) {
        // Retrieve the asset from asset_disposal table
        AssetDisposal assetDisposal = repository.findById(assetDisposalId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        // Convert AssetDisposal to DisposedAssetItem
        DisposedAssetItems disposedAssetItem = convertToDisposedAssetItem(assetDisposal);

        // Save in disposed_asset_items table
        dRepository.save(disposedAssetItem);

        // Remove from asset_disposal table
        repository.deleteById(assetDisposalId);
    }

    // This method is used to convert an AssetDisposal object to a DisposedAssetItems object so that it can be saved in the disposed_asset_items table
    private DisposedAssetItems convertToDisposedAssetItem(AssetDisposal assetDisposal) {
        DisposedAssetItems disposedAssetItem = new DisposedAssetItems();
        disposedAssetItem.setType(assetDisposal.getType());
        disposedAssetItem.setSerialNumber(assetDisposal.getSerialNumber());
        disposedAssetItem.setExtraInformation(assetDisposal.getExtraInformation());
        disposedAssetItem.setDisposalDate(assetDisposal.getDisposalDate());
        disposedAssetItem.setDisposalReason(assetDisposal.getDisposalReason());

        return disposedAssetItem;
    }


}
