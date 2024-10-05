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
@Table(name = "Routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeIdentifier;

    @Column(name = "start_point")
    private String startPoint;

    @Column(name = "end_point")
    private String endPoint;
    
    @Column(name = "dt_recordedattime")
    private LocalDateTime recordedAtTime;

    // Getters and Setters
    public Long getId() {
        return routeIdentifier;
    }

    public void setId(Long routeIdentifier) {
        this.routeIdentifier = routeIdentifier;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
    
    public LocalDateTime getRecordedAtTime() {
        return recordedAtTime;
    }

    public void setRecordedAtTime(LocalDateTime localDateTime) {
        this.recordedAtTime = localDateTime;
    }
}

