package com.lms.LMS.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trafficdata")
public class TrafficData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trafficDataIdentifier;

    @Column(name = "traffic_status")
    private String trafficStatus;

    @Column(name = "est_traveltime")
    private Long estimatedTravelTime;
    
    @Column(name = "retrieved_at")
    private LocalDate retrievedAt;
    
    @ManyToOne
    @JoinColumn(name = "id_route")
    private Routes routeIdentifier;
    

    // Getters and Setters
    public Long getTrafficDataIdentifier() {
        return trafficDataIdentifier;
    }

    public void setTrafficDataIdentifier(Long trafficDataIdentifier) {
        this.trafficDataIdentifier = trafficDataIdentifier;
    }

    public String getTrafficStatus() {
        return trafficStatus;
    }

    public void setTrafficStatus(String trafficStatus) {
        this.trafficStatus = trafficStatus;
    }
    
    public Long getEstimatedTravelTime() {
        return estimatedTravelTime;
    }

    public void setEstimatedTravelTime(Long estimatedTravelTime) {
        this.estimatedTravelTime = estimatedTravelTime;
    }
    
    public LocalDate getRetrievedAt() {
        return retrievedAt;
    }

    public void setRetrievedAt(LocalDate retrievedAt) {
        this.retrievedAt = retrievedAt;
    }
    
    public Routes getRouteIdentifier() {
        return routeIdentifier;
    }

    public void setRouteIdentifier(Routes routeIdentifier) {
        this.routeIdentifier = routeIdentifier;
    }
}

