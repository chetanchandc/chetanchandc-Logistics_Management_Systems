package com.lms.LMS.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.LMS.entity.Shipments;

@Repository
public interface ShipmentsRepository extends JpaRepository<Shipments, Long> {

	// List<Shipments> findByTrackingNumber(String trackingNumber);
    // Additional custom query methods (if needed) can be defined here
	Optional<Shipments> findByTrackingNumber(String trackingNumber);
	
	// Custom method to delete all shipments by tracking number using bulk delete
    @Modifying
    @Transactional
    @Query("DELETE FROM Shipments s WHERE s.trackingNumber = '123ABC'")
    void deleteByTrackingNumber(String trackingNumber);  // Bulk delete method
}