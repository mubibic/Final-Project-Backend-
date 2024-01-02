package com.example.agcbiohardwareinventorysystembackend.Repository;

import com.example.agcbiohardwareinventorysystembackend.Entity.AssetDisposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This interface is for the AssetDisposalRepository which extends the JpaRepository interface to perform
// CRUD operations on the AssetDisposal entity in the database using the methods provided by the JpaRepository interface

// This annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects
@Repository
public interface AssetDisposalRepository extends JpaRepository<AssetDisposal, Integer> {

}
