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
