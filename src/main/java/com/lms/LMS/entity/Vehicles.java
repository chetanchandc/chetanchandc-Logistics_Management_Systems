package com.lms.LMS.entity;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vehicles")
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_driver")
    private String driverIdentifier;

    @Column(name = "current_location")
    private String currentLocation;
    
    @Column(name = "dt_recordedattime")
    private LocalDateTime recordedAtTime;
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverIdentifier() {
        return driverIdentifier;
    }

    public void setDriverIdentifier(String driverIdentifier) {
        this.driverIdentifier = driverIdentifier;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    public LocalDateTime getRecordedAtTime() {
        return recordedAtTime;
    }

    public void setRecordedAtTime(LocalDateTime localDateTime) {
        this.recordedAtTime = localDateTime;
    }
}