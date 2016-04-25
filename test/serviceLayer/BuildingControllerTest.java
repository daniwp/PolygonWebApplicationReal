/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dataAccessLayer.mapper.BuildingMapper;
import dataAccessLayer.mapper.FloorMapper;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import serviceLayer.entity.Building;
import serviceLayer.entity.Floor;

/**
 *
 * @author danie
 */
public class BuildingControllerTest {

    BuildingController buildingController = new BuildingController();

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
        BuildingController buildingController = new BuildingController();
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
     * Test of getBuildingIdByName method, of class BuildingController.
     */
    @Test
    public void testGetBuildingIdByName() {
        System.out.println("Testing getBuildingIdByName(String name) method");
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
        System.out.println("Testing the getBuildingByBuildingId(int buildingId) method");
        int buildingId = 1;
        BuildingController instance = new BuildingController();
        Building expResult = null;
        Building result = instance.getBuildingByBuildingId(buildingId);

        assertNotNull(result);
    }

    /**
     * Test of getAllBuildingsByCustomerId method, of class BuildingController.
     */
    @Test
    public void testGetAllBuildingsByCustomerId() {
        System.out.println("Testing the getAllBuildingsByCustomerId(int customerId) method");
        int CustomerId = 1;
        BuildingController instance = new BuildingController();
        List<Building> result = instance.getAllBuildingsByCustomerId(CustomerId);

        for (Building building : result) {
            assertNotNull(building);
        }
    }

    /**
     * Test of updateBuildingFloorsByBuildingId method, of class
     * BuildingController.
     */
    @Test
    public void testUpdateBuildingFloorsByBuildingId() {
        System.out.println("Testing the updateBuildingFloorsByBuildingId(int buildingId) method");

        int buildingId = 1;

        BuildingController instance = new BuildingController();
        BuildingMapper buildingMapper = new BuildingMapper();
        FloorMapper floorMapper = new FloorMapper();
        Floor floor = new Floor(99, 10.50, buildingId);

        int floorsBefore = buildingMapper.getNumberOfFloorsByBuildingId(buildingId);

        floorMapper.addFloor(floor);
        instance.updateBuildingFloorsByBuildingId(buildingId);

        int floorsAfter = buildingMapper.getNumberOfFloorsByBuildingId(buildingId);

        assertFalse(floorsBefore == floorsAfter);
    }

    /**
     * Test of editBuildingByBuildingId method, of class BuildingController.
     */
    @Test
    public void testEditBuildingByBuildingId() throws Exception {

        String nameBefore = "Building Name";
        String addressBefore = "Building Address 123";
        int zipcodesBefore = 2980;
        String cityBefore = "Building City";
        int buildingYearBefore = 1994;
        int floorsBefore = 420;
        double totalSizeBefore = 133.7;
        String buildingOwnerBefore = "Building Owner";
        int buildingConditionBefore = 2;
        int costumerIdBefore = 1;

        buildingController.addBuilding(nameBefore, addressBefore, zipcodesBefore, cityBefore, buildingYearBefore, floorsBefore, totalSizeBefore, buildingOwnerBefore, buildingConditionBefore, costumerIdBefore);
        int buildingId = buildingController.getBuildingIdByName(nameBefore);
        Building buildingBefore = buildingController.getBuildingByBuildingId(buildingId);

        String nameAfter = "Building NameAfter";
        String addressAfter = "Building Address 123After";
        int zipcodesAfter = 2981;
        String cityAfter = "Building CityAfter";
        int buildingYearAfter = 1995;
        int floorsAfter = 421;
        double totalSizeAfter = 133.75;
        String buildingOwnerAfter = "Building OwnerAfter";
        int buildingConditionAfter = 0;

        Building buildingAfter = new Building(nameAfter, addressAfter, zipcodesAfter, cityAfter, buildingYearAfter, floorsAfter, totalSizeAfter, buildingOwnerAfter, buildingConditionAfter, costumerIdBefore);

        buildingController.editBuildingByBuildingId(buildingId, nameAfter, addressAfter, zipcodesAfter, cityAfter, buildingYearAfter, floorsAfter, totalSizeAfter, buildingOwnerAfter, buildingConditionAfter);

        assertTrue(nameAfter.equals(buildingAfter.getName()));
        assertTrue(addressAfter.equals(buildingAfter.getAddress()));
        assertTrue(zipcodesAfter == buildingAfter.getZipcodes());
        assertTrue(cityAfter.equals(buildingAfter.getCity()));
        assertTrue(buildingYearAfter == buildingAfter.getBuildingYear());
        assertTrue(floorsAfter == buildingAfter.getFloors());
        assertTrue(totalSizeAfter == buildingAfter.getTotalSize());
        assertTrue(buildingOwnerAfter.equals(buildingAfter.getBuildingOwner()));
        assertTrue(buildingConditionAfter == buildingAfter.getBuildingCondition());
    }

    /**
     * Test of deleteBuildingByBuildingId method, of class BuildingController.
     */
    @Test
    public void testDeleteBuildingByBuildingId() throws Exception{

        System.out.println("Testing the deleteBuildingByBuildingId(int buildingId) method");

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

        buildingController.addBuilding(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId);
        int buildingId = buildingController.getBuildingIdByName(name);

        BuildingController buildingController = new BuildingController();
        buildingController.deleteBuildingByBuildingId(buildingId);

        Building building = buildingController.getBuildingByBuildingId(buildingId);

        assertTrue(building == null);

    }
}
