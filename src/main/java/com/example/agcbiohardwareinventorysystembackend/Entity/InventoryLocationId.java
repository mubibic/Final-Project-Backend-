package com.example.agcbiohardwareinventorysystembackend.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InventoryLocationId implements Serializable {
    private int inventoryId;
    private String location;

    // Constructors, getters, and setters
}
