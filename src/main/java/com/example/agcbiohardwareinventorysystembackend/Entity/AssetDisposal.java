package com.example.agcbiohardwareinventorysystembackend.Entity;

import jakarta.persistence.*;

import java.security.Timestamp;
// This class is for the Asset Disposal entity in the database

// This annotation is used to mark the class as an entity class which means that it will be mapped to a table in the database
@Entity
public class AssetDisposal {
    // This annotation is used to mark the primary key of the table in the database,
    // and it is auto incremented by 1 for each new record added to the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String serialNumber;
    private String extraInformation;
    private String disposalDate;
    private String disposalReason;


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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
    }

    public String getDisposalDate() {
        return disposalDate;
    }

    public void setDisposalDate(String disposalDate) {
        this.disposalDate = disposalDate;
    }

    public String getDisposalReason() {
        return disposalReason;
    }

    public void setDisposalReason(String disposalReason) {
        this.disposalReason = disposalReason;
    }
}
