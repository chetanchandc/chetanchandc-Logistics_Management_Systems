package com.lms.LMS.service;

import com.lms.LMS.entity.Vehicles;
import com.lms.LMS.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiclesService {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    // Create a new vehicle
    public Vehicles createVehicle(Vehicles vehicle) {
        return vehiclesRepository.save(vehicle);
    }

    // Find a vehicle by ID
    public Optional<Vehicles> getVehicleById(Long id) {
        return vehiclesRepository.findById(id);
    }

    // Get all vehicles
    public List<Vehicles> getAllVehicles() {
        return vehiclesRepository.findAll();
    }

    // Update a vehicle
    public Vehicles updateVehicle(Long id, Vehicles updatedVehicle) {
        return vehiclesRepository.findById(id)
            .map(vehicle -> {
                vehicle.setCurrentLocation(updatedVehicle.getCurrentLocation());
                vehicle.setDriverIdentifier(updatedVehicle.getDriverIdentifier());
                return vehiclesRepository.save(vehicle);
            })
            .orElseThrow(() -> new RuntimeException("Vehicle not found with id " + id));
    }

    // Delete a vehicle by ID
    public void deleteVehicle(Long id) {
        vehiclesRepository.deleteById(id);
    }
}
