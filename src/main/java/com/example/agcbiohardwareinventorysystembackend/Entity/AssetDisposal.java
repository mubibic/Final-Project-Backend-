package com.example.agcbiohardwareinventorysystembackend.Entity;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
public class AssetDisposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String serialNumber;
    private String hddSerialNumber;
    private String extraInformation;
    private String disposalDate;
    private String disposalReason;

    // Constructors, getters, and setters
}
