package com.lms.LMS.repository_test;

import com.lms.LMS.entity.Routes;
import com.lms.LMS.repository.RoutesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)  // Disable rollback

public class RoutesRepositoryTest {

    @Autowired
    private RoutesRepository routesRepository;

    @BeforeEach
    void setUp() {
        // Clear existing data
        routesRepository.deleteAll();

        // Prepare test data
        Routes route1 = new Routes();
        route1.setStartPoint("A");
        route1.setEndPoint("B");
        route1.setRecordedAtTime(LocalDateTime.now().minusDays(1));  // Corrected: Ensure time is set

        Routes route2 = new Routes();
        route2.setStartPoint("C");
        route2.setEndPoint("D");
        route2.setRecordedAtTime(LocalDateTime.now().minusHours(5));  // Corrected: Ensure time is set

        routesRepository.save(route1);
        routesRepository.save(route2);
        
        // Optionally, print out the IDs to ensure they are being saved
        System.out.println("Saved Route 1 ID: " + route1.getId());
        System.out.println("Saved Route 2 ID: " + route2.getId());
    }
    
    @Commit  // Commit transaction instead of rolling back
    /*
    @Test
    public void testSaveRoute() {
        Routes route = new Routes();
        route.setStartPoint("E");
        route.setEndPoint("F");
        // route.setRecordedAtTime(LocalDateTime.now());
        
        Routes savedRoute = routesRepository.save(route);
        assertThat(savedRoute).isNotNull();
        assertThat(savedRoute.getId()).isNotNull();
    }*/
    
    @Test
    public void testFindRouteById() {
        Routes savedRoute = routesRepository.findAll().get(0);  // Get the first saved route
        Optional<Routes> route = routesRepository.findById(savedRoute.getId());
        
        assertThat(route).isPresent();
        assertThat(route.get().getStartPoint()).isEqualTo("A");
    }
    /*
    @Test
    public void testFindAllRoutes() {
        List<Routes> routes = routesRepository.findAll();
        System.out.println("Number of routes found: " + routes.size());
        
        assertThat(routes).hasSize(2); // Ensure that there are exactly 2 routes
    }

    
    @Test
    public void testDeleteRoute() {
        Routes savedRoute = routesRepository.findAll().get(0);  // Get the first saved route
        Optional<Routes> routeOptional = routesRepository.findById(savedRoute.getId());
        assertThat(routeOptional).isPresent();  // Ensure the entity is present
        
        Routes route = routeOptional.get();
        routesRepository.delete(route);  // Delete the entity

        Optional<Routes> deletedRoute = routesRepository.findById(route.getId());
        assertThat(deletedRoute).isEmpty();  // Ensure it's deleted
    }*/
}
