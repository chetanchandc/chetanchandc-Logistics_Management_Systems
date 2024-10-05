package com.lms.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.LMS.entity.Routes;

@Repository
public interface RoutesRepository extends JpaRepository<Routes, Long> {
    // Additional custom query methods (if needed) can be defined here
}
