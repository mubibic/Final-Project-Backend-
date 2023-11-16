package com.example.agcbiohardwareinventorysystembackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class InventoryLocation {
    @EmbeddedId
    private InventoryLocationId id;

    @ManyToOne
    // inventory_id is a foreign key and connects to id in inventory_in_stock
    @MapsId("inventoryId")
    @JoinColumn(name = "inventory_id")
    private InventoryInStock inventoryInStock;

    private int quantity;

    // Constructors, getters, and setters

    public InventoryLocationId getId() {
        return id;
    }

    public void setId(InventoryLocationId id) {
        this.id = id;
    }

    public InventoryInStock getInventoryInStock() {
        return inventoryInStock;
    }

    public void setInventoryInStock(InventoryInStock inventoryInStock) {
        this.inventoryInStock = inventoryInStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


