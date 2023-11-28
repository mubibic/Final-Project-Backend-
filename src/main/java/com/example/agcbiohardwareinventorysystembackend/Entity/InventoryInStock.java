package com.example.agcbiohardwareinventorysystembackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;


@Entity
public class InventoryInStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String model;
    private String extraInformation;

    @OneToMany(mappedBy = "inventoryInStock")
    @JsonBackReference
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
