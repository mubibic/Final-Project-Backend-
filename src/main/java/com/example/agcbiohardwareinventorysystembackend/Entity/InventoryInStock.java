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
}
