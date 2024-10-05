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
@Table(name = "weatherdata")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weatherDataIdentifier;

    @Column(name = "dsc_weather")
    private String weatherDescription;

    @Column(name = "temperature")
    private BigDecimal temperature;
    
    @Column(name = "retrieved_at")
    private LocalDate retrievedAt;
    
    @ManyToOne
    @JoinColumn(name = "id_route")
    private Routes routeIdentifier;
    

    // Getters and Setters
    public Long getWeatherDataIdentifier() {
        return weatherDataIdentifier;
    }

    public void setWeatherDataIdentifier(Long weatherDataIdentifier) {
        this.weatherDataIdentifier = weatherDataIdentifier;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
    
    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
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

