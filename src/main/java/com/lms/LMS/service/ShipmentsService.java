package com.lms.LMS.service;

import com.lms.LMS.entity.Shipments;
import com.lms.LMS.repository.ShipmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentsService {

    @Autowired
    private ShipmentsRepository shipmentsRepository;
    
    public Shipments createShipment(Shipments shipment) {
        if (shipment.getTrackingNumber() == null || shipment.getTrackingNumber().isEmpty()) {
            throw new IllegalArgumentException("Tracking number is required.");
        }

        if (shipmentExists(shipment.getTrackingNumber())) {
            throw new IllegalArgumentException("Duplicate Tracking Number. Tracking number already exists.");
        }

        // Additional validation (origin, destination)
        if (shipment.getOrigin() == null || shipment.getDestination() == null) {
            throw new IllegalArgumentException("Origin and destination are required.");
        }

        return shipmentsRepository.save(shipment);
    }

	private boolean shipmentExists(String trackingNumber) {
		// TODO Auto-generated method stub
		return false;
	}

    /*
    // Create a new shipment
    public Shipments createShipment(Shipments shipment) {
        return shipmentsRepository.save(shipment);
    }

    // Find a shipment by ID
    public Optional<Shipments> getShipmentById(Long id) {
        return shipmentsRepository.findById(id);
    }

    // Find all shipments
    public List<Shipments> getAllShipments() {
        return shipmentsRepository.findAll();
    }

    // Update an existing shipment
    public Shipments updateShipment(Long id, Shipments updatedShipment) {
        return shipmentsRepository.findById(id)
            .map(shipment -> {
                shipment.setTrackingNumber(updatedShipment.getTrackingNumber());
                shipment.setStatus(updatedShipment.getStatus());
                return shipmentsRepository.save(shipment);
            })
            .orElseThrow(() -> new RuntimeException("Shipment not found with id " + id));
    }

    // Delete a shipment by ID
    public void deleteShipment(Long id) {
        shipmentsRepository.deleteById(id);
    }

    // Delete all shipments with a specific tracking number
    public void deleteShipmentsByTrackingNumber(String trackingNumber) {
        shipmentsRepository.deleteByTrackingNumber(trackingNumber);
    }*/
}
