package com.example.agcbiohardwareinventorysystembackend.Entity;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class InventoryInStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String modelNumber;
    private String extraInformation;

    @OneToMany(mappedBy = "inventoryInStock")
    private Set<InventoryLocation> locations;

    // Constructors, getters, and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
    }

    public Set<InventoryLocation> getLocations() {
        return locations;
    }

    public void setLocations(Set<InventoryLocation> locations) {
        this.locations = locations;
    }
}
