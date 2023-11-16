package com.example.agcbiohardwareinventorysystembackend.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InventoryLocationId implements Serializable {
    private int inventoryId;
    private String location;

    // Constructors, getters, and setters

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
