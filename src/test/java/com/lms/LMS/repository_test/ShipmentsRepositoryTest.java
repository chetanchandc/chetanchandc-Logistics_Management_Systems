package com.lms.LMS.repository_test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lms.LMS.entity.Shipments;
import com.lms.LMS.repository.ShipmentsRepository;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)  // Disable rollback

public class ShipmentsRepositoryTest {
	@Autowired
    private ShipmentsRepository shipmentsRepository;

    @BeforeEach
    // consider setting up the test data in a @BeforeEach setup method 
    // to ensure a consistent starting point for all tests.
    void setUp() {
    	// Clear existing data to ensure a clean test environment
        shipmentsRepository.deleteAll();
        
        // Prepare test data
        Shipments shipment1 = new Shipments();
        shipment1.setTrackingNumber("123ABC");
        shipment1.setStatus("In Transit");

        Shipments shipment2 = new Shipments();
        shipment2.setTrackingNumber("456DEF");
        shipment2.setStatus("Delivered");


        shipmentsRepository.save(shipment1);
        shipmentsRepository.save(shipment2);
    }
    
    @Commit  // Commit transaction instead of rolling back
  
    
  /*  
    @Test 
    public void testAllMethods() {
    	// saveNewShipment: Save Operation
    	Shipments saveNewShipment = new Shipments();
    	saveNewShipment.setTrackingNumber("789GHI");
    	saveNewShipment.setStatus("Pending");
    	
    	Shipments newShipmentData = shipmentsRepository.save(saveNewShipment);

    	assertThat(newShipmentData).isNotNull();
        assertThat(newShipmentData.getId()).isGreaterThan(0);
        
        // findById: Find Operation
    	Shipments findShipmentData = shipmentsRepository.findAll().get(0); // Find all and Get the first shipment
    	Optional<Shipments> findShipmentDataById = shipmentsRepository.findById(findShipmentData.getId());
    	
        assertThat(findShipmentDataById).isPresent();
        assertThat(findShipmentDataById.get().getTrackingNumber()).isEqualTo("123ABC");
        
        // findAllIds: Find Operation to find all
        List<Shipments> findAllShipmentDataById = shipmentsRepository.findAll();

        assertThat(findAllShipmentDataById).hasSize(3); // Assuming the setup is consistent
        
        // FindByTrackingNumber: Custom Operation to find tracking number
        Optional<Shipments> findShipmentByTrackingNumber = shipmentsRepository.findByTrackingNumber("123ABC");
        
        assertThat(findShipmentByTrackingNumber).isPresent();  // Check that the Optional is not empty
        assertThat(findShipmentByTrackingNumber.get().getStatus()).isEqualTo("In Transit");    
        
        // deleteById: Delete Operation to delete tracking number by ID
        Optional<Shipments> findShipment = shipmentsRepository.findByTrackingNumber("123ABC");
        assertThat(findShipment).isPresent();  // Check if the entity is present
        
        Shipments getShipmentToBeDeleted = findShipment.get();  // Retrieve the entity safely

        shipmentsRepository.delete(getShipmentToBeDeleted);  // Delete the entity
        
        Optional<Shipments> deletedShipment = shipmentsRepository.findById(getShipmentToBeDeleted.getId());
        assertThat(deletedShipment).isEmpty();  // Ensure it's deleted
    }
*/
    /*
    @Test // each test should set up its data independently in @BeforeEach
    // @DirtiesContext  // ensures that the application context is reloaded in DB for the next test
    public void testSaveShipment() {
        Shipments shipment = new Shipments();
        shipment.setTrackingNumber("789GHI");
        shipment.setStatus("Pending");

        Shipments savedShipment = shipmentsRepository.save(shipment);

        assertThat(savedShipment).isNotNull();
        assertThat(savedShipment.getId()).isGreaterThan(0);
    }*/

    @Test // each test should set up its data independently in @BeforeEach
    public void testFindShipmentById() {
        Shipments savedShipment1 = shipmentsRepository.findAll().get(0);  // Get the first saved shipment
        Shipments savedShipment2 = shipmentsRepository.findAll().get(1);
        Optional<Shipments> shipment1 = shipmentsRepository.findById(savedShipment1.getId());
        Optional<Shipments> shipment2 = shipmentsRepository.findById(savedShipment2.getId());
        
        assertThat(shipment1).isPresent();
        assertThat(shipment2).isPresent();
        assertThat(shipment1.get().getTrackingNumber()).isEqualTo("123ABC");
        assertThat(shipment2.get().getTrackingNumber()).isEqualTo("456DEF");
        
        // insert if else loop to PRINT the result
    }
    /*
    @Test // each test should set up its data independently in @BeforeEach
    public void testFindAllShipments() {
        List<Shipments> shipments = shipmentsRepository.findAll();
        
        assertThat(shipments).hasSize(21);  // Assuming the setup is consistent
    }
    
    @Test // each test should set up its data independently in @BeforeEach
    // Custom Finder
    public void testFindByTrackingNumber() {
        Shipments savedShipment = shipmentsRepository.findAll().get(0);  // Get the first saved shipment

        Optional<Shipments> shipment = shipmentsRepository.findByTrackingNumber(savedShipment.getTrackingNumber());
        
        assertThat(shipment).isNotEmpty();
        System.out.println("Tracking number retrieved");
        // assertThat(shipment.get(0).getStatus()).isEqualTo("Delivered"); //hardcoding
        assertThat(shipment.get().getStatus()).isEqualTo(savedShipment.getStatus());  // No hardcoding
        System.out.println("Tracking number found: " + shipment.get().getTrackingNumber());

    }
    
    @Test // each test should set up its data independently in @BeforeEach
    public void testDeleteShipment() {
        Shipments toBeDeletedShipment = shipmentsRepository.findAll().get(0);  // Get the first shipment

        Optional<Shipments> shipmentOptional = shipmentsRepository.findByTrackingNumber(toBeDeletedShipment.getTrackingNumber());
        
        assertThat(shipmentOptional).isNotEmpty();  // Check if the entity is present
        
        Shipments shipment = shipmentOptional.get();  // Retrieve the entity safely
        
        shipmentsRepository.delete(shipment);  // Delete the entity

        Optional<Shipments> deletedShipment = shipmentsRepository.findById(shipment.getId());
        
        assertThat(deletedShipment).isEmpty();  // Ensure it's deleted
        // in this test method, it deleted only the first tracking number entity.
        // find out how to delete all the tracking numbers with the same ID.
    }
    
    @Test   // Bulk Delete test method
    public void testBulkDeleteShipmentsWithSameTrackingNumber() {
        // Step 1: Retrieve all shipments
        List<Shipments> allShipments = shipmentsRepository.findAll();

        // Ensure there is at least one shipment in the database to proceed
        assertThat(allShipments).isNotEmpty();

        // Step 2: Extract unique tracking numbers dynamically
        Set<String> uniqueTrackingNumbers = allShipments.stream().map(Shipments::getTrackingNumber).collect(Collectors.toSet());

        // Print all unique tracking numbers to be deleted (for debugging)
        System.out.println("Unique tracking numbers to be deleted: " + uniqueTrackingNumbers);

        // Step 3: Iterate over each unique tracking number and perform bulk delete
        for (String trackingNumber : uniqueTrackingNumbers) {
            // Print the tracking number to be deleted (for debugging)
            System.out.println("Deleting all shipments with tracking number: " + trackingNumber);

            // Perform bulk delete for all shipments with this tracking number
            shipmentsRepository.deleteByTrackingNumber(trackingNumber);

            // Step 4: Verify deletion for this tracking number
            Optional<Shipments> remainingShipments = shipmentsRepository.findByTrackingNumber(trackingNumber);

            // Ensure all shipments with the current tracking number are deleted
            assertThat(remainingShipments).isEmpty();  // The list should be empty if all were deleted
        }
    }*/

}
