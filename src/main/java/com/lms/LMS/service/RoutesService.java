package com.lms.LMS.service;

import com.lms.LMS.entity.Routes;
import com.lms.LMS.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutesService {

    @Autowired
    private RoutesRepository routesRepository;

    // Create a new route
    public Routes createRoute(Routes route) {
        return routesRepository.save(route);
    }

    // Find a route by ID
    public Optional<Routes> getRouteById(Long id) {
        return routesRepository.findById(id);
    }

    // Get all routes
    public List<Routes> getAllRoutes() {
        return routesRepository.findAll();
    }

    // Update a route
    public Routes updateRoute(Long id, Routes updatedRoute) {
        return routesRepository.findById(id)
            .map(route -> {
                route.setStartPoint(updatedRoute.getStartPoint());
                route.setEndPoint(updatedRoute.getEndPoint());
                return routesRepository.save(route);
            })
            .orElseThrow(() -> new RuntimeException("Route not found with id " + id));
    }

    // Delete a route by ID
    public void deleteRoute(Long id) {
        routesRepository.deleteById(id);
    }
}
