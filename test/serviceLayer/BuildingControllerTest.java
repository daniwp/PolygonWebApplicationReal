/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import serviceLayer.entity.Building;

/**
 *
 * @author danie
 */
public class BuildingControllerTest {

    public BuildingControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addBuilding method, of class BuildingController.
     */
    @Test
    public void testAddBuilding() throws Exception {
        System.out.println("Testing the addBuilding(Building building) method");

        String name = "Building Name";
        String address = "Building Address 123";
        int zipcodes = 2980;
        String city = "Building City";
        int buildingYear = 1994;
        int floors = 420;
        double totalSize = 133.7;
        String buildingOwner = "Building Owner";
        int buildingCondition = 2;
        int costumerId = 1;

        BuildingController buildingController = new BuildingController();

        buildingController.addBuilding(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId);
        Building building = buildingController.getBuildingByBuildingId(buildingController.getBuildingIdByName(name));

        assertTrue(name.equals(building.getName()));
        assertTrue(address.equals(building.getAddress()));
        assertTrue(zipcodes == building.getZipcodes());
        assertTrue(city.equals(building.getCity()));
        assertTrue(buildingYear == building.getBuildingYear());
        assertTrue(floors == building.getFloors());
        assertTrue(totalSize == building.getTotalSize());
        assertTrue(buildingOwner.equals(building.getBuildingOwner()));
        assertTrue(buildingCondition == building.getBuildingCondition());
        assertTrue(costumerId == building.getCustomerId());

    }

    /**
     * Test of deleteBuildingByBuildingId method, of class BuildingController.
     */
    @Test
    public void testDeleteBuildingByBuildingId() {
        /*
         System.out.println("Testing the deleteBuildingByBuildingId(int buildingId) method");
        
         int buildingId = 1;
        
         BuildingController buildingController = new BuildingController();
         buildingController.deleteBuildingByBuildingId(buildingId);

         Building building = buildingController.getBuildingByBuildingId(buildingId);
        
         assertTrue(building == null);
         */
    }

    /**
     * Test of getBuildingIdByName method, of class BuildingController.
     */
    @Test
    public void testGetBuildingIdByName() {
        System.out.println("getBuildingIdByName");
        String name = "Arla Foods Copenhagen";
        BuildingController instance = new BuildingController();
        int expResult = 1;
        int result = instance.getBuildingIdByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBuildingByBuildingId method, of class BuildingController.
     */
    @Test
    public void testGetBuildingByBuildingId() {
        System.out.println("getBuildingByBuildingId");
        int buildingId = 0;
        BuildingController instance = new BuildingController();
        Building expResult = null;
        Building result = instance.getBuildingByBuildingId(buildingId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBuildingsByCustomerId method, of class BuildingController.
     */
    @Test
    public void testGetAllBuildingsByCustomerId() {
        System.out.println("getAllBuildingsByCustomerId");
        int CustomerId = 0;
        BuildingController instance = new BuildingController();
        List<Building> expResult = null;
        List<Building> result = instance.getAllBuildingsByCustomerId(CustomerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBuildingFloorsByBuildingId method, of class
     * BuildingController.
     */
    @Test
    public void testUpdateBuildingFloorsByBuildingId() {
        System.out.println("updateBuildingFloorsByBuildingId");
        int buildingId = 0;
        BuildingController instance = new BuildingController();
        instance.updateBuildingFloorsByBuildingId(buildingId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editBuildingByBuildingId method, of class BuildingController.
     */
    @Test
    public void testEditBuildingByBuildingId() throws Exception {
        System.out.println("editBuildingByBuildingId");
        int buildingId = 0;
        String name = "";
        String address = "";
        int zipcode = 0;
        String city = "";
        int buildingYear = 0;
        int floors = 0;
        double totalSize = 0.0;
        String buildingOwner = "";
        int buildingCondition = 0;
        BuildingController instance = new BuildingController();
        instance.editBuildingByBuildingId(buildingId, name, address, zipcode, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
