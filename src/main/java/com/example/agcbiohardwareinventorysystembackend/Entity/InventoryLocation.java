package com.example.agcbiohardwareinventorysystembackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class InventoryLocation {
    @EmbeddedId
    private InventoryLocationId id;

    @ManyToOne
    @MapsId("inventoryId")
    @JoinColumn(name = "inventory_id")
    private InventoryInStock inventoryInStock;

    private int quantity;

    // Constructors, getters, and setters
}


