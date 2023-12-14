package com.example.agcbiohardwareinventorysystembackend.Service;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Entity.DisposedAssetItems;
import com.example.agcbiohardwareinventorysystembackend.Repository.AssetDisposalRepository;
import com.example.agcbiohardwareinventorysystembackend.Repository.DisposedAssetItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposedAssetItemsService {

    private final DisposedAssetItemsRepository dRepository;
    private final AssetDisposalRepository repository;


    @Autowired
    public DisposedAssetItemsService(DisposedAssetItemsRepository dRepository, AssetDisposalRepository repository) {
        this.dRepository = dRepository;
        this.repository = repository;
    }

    public List<DisposedAssetItems> findAll() {
        return dRepository.findAll();
    }

    public void transferBackFromDisposed(int disposedAssetItemId) {
        DisposedAssetItems disposedItem = dRepository.findById(disposedAssetItemId)
                .orElseThrow(() -> new RuntimeException("Disposed asset not found"));

        AssetDisposal assetDisposal = convertToAssetDisposal(disposedItem);

        repository.save(assetDisposal);
        dRepository.deleteById(disposedAssetItemId);
    }
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
