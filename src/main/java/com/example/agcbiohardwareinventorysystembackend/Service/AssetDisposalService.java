package com.example.agcbiohardwareinventorysystembackend.Service;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import com.example.agcbiohardwareinventorysystembackend.Repository.AssetDisposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetDisposalService {

    private final AssetDisposalRepository repository;

    @Autowired
    public AssetDisposalService(AssetDisposalRepository repository) {
        this.repository = repository;
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

    // Additional methods as required
}
