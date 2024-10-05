package com.lms.LMS.repository_test;

import com.lms.LMS.entity.Vehicles;
import com.lms.LMS.repository.VehiclesRepository;

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
@TestPropertySource(locations = "classpath:application-test.properties") // Ensure this file is correctly set up
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)  // Disable rollback

public class VehiclesRepositoryTest {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    @BeforeEach
    void setUp() {
        // Clear existing data
        vehiclesRepository.deleteAll();

        // Prepare test data
        Vehicles vehicle1 = new Vehicles();
        vehicle1.setCurrentLocation("X");
        vehicle1.setDriverIdentifier("101L");
        vehicle1.setRecordedAtTime(LocalDateTime.now().minusDays(2));

        Vehicles vehicle2 = new Vehicles();
        vehicle2.setCurrentLocation("Y");
        vehicle2.setDriverIdentifier("102L");
        vehicle2.setRecordedAtTime(LocalDateTime.now().minusHours(10));

        vehiclesRepository.save(vehicle1);
        vehiclesRepository.save(vehicle2);
    }
    
    @Commit  // Commit transaction instead of rolling back
    /*
    @Test
    public void testSaveVehicle() {
        Vehicles vehicle = new Vehicles();
        vehicle.setCurrentLocation("Z");
        vehicle.setDriverIdentifier("103L");
        // vehicle.setRecordedAtTime(LocalDateTime.now());
        
        Vehicles savedVehicle = vehiclesRepository.save(vehicle);
        assertThat(savedVehicle).isNotNull();
        assertThat(savedVehicle.getId()).isNotNull();
    }*/
    
    @Test
    public void testFindVehicleById() {
    	Vehicles savedVehicle = vehiclesRepository.findAll().get(0);  // Get the first saved vehicle
        Optional<Vehicles> vehicle = vehiclesRepository.findById(savedVehicle.getId());
        
        assertThat(vehicle).isPresent();
        assertThat(vehicle.get().getCurrentLocation()).isEqualTo("X");
    }
    /*
    @Test
    public void testFindAllVehicles() {
        List<Vehicles> vehicles = vehiclesRepository.findAll();
        System.out.println("Number of vehicles found: " + vehicles.size());
        
        assertThat(vehicles).hasSize(2); // Ensure that there are exactly 2 vehicles
    }
    
 
    @Test
    public void testDeleteVehicle() {
    	Vehicles savedVehicle = vehiclesRepository.findAll().get(0);  // Get the first saved vehicle
        
    	Optional<Vehicles> vehcileOptional = vehiclesRepository.findById(savedVehicle.getId());
        assertThat(vehcileOptional).isPresent();  // Ensure the entity is present

    	Vehicles vehicle = vehcileOptional.get();
        vehiclesRepository.delete(vehicle); // Delete the entity
        
        Optional<Vehicles> deletedVehicle = vehiclesRepository.findById(vehicle.getId());
        assertThat(deletedVehicle).isEmpty();   // Ensure the entity deleted
    }*/

}
