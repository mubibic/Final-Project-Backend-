package com.example.agcbiohardwareinventorysystembackend.Service;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Repository.AssetDisposalRepository;
import com.example.agcbiohardwareinventorysystembackend.Repository.DisposedAssetItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetDisposalService {

    private final AssetDisposalRepository repository;
    private final DisposedAssetItemsRepository dRepository;

    @Autowired
    public AssetDisposalService(AssetDisposalRepository repository, DisposedAssetItemsRepository dRepository) {
        this.repository = repository;
        this.dRepository = dRepository;
    }

    public AssetDisposal save(AssetDisposal assetDisposal) {
        return repository.save(assetDisposal);
    }

    public Optional<AssetDisposal> findById(int id) {
        return repository.findById(id);
    }

    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    public List<AssetDisposal> findAll() {
        return repository.findAll();
    }

    public AssetDisposal update(AssetDisposal assetDisposal) {
        return repository.save(assetDisposal);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

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
