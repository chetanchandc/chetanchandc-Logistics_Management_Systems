package com.lms.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.LMS.entity.Vehicles;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {
    // Additional custom query methods (if needed) can be defined here
}
