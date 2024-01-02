package com.example.agcbiohardwareinventorysystembackend.Entity;

import jakarta.persistence.*;

import java.util.Set;
// This class is for the Inventory In Stock entity in the database

// This annotation is used to mark the class as an entity class which means that it will be mapped to a table in the database
@Entity
public class InventoryInStock {
    // This annotation is used to mark the primary key of the table in the database,
    // and it is auto incremented by 1 for each new record added to the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String model;
    private String extraInformation;

    private int quantity;

    private String location;


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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
