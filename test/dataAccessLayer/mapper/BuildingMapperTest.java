/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessLayer.mapper;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import serviceLayer.BuildingController;
import serviceLayer.entity.Building;
import serviceLayer.entity.Floor;

/**
 *
 * @author Daniel
 */
public class BuildingMapperTest {

    BuildingMapper buildingMapper = new BuildingMapper();

    public BuildingMapperTest() {
    }

    /**
     * Test of addBuilding method, of class BuildingMapper.
     */
    @Test
    public void testAddBuilding() {
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

        buildingMapper.addBuilding(new Building(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId));
        Building building = buildingMapper.getBuildingByBuildingId(buildingMapper.getBuildingIdByName(name));

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
     * Test of getAllBuildingsByCustomerId method, of class BuildingMapper.
     */
    @Test
    public void testGetAllBuildingsByCustomerId() {
        System.out.println("Testing the getAllBuildingsByCustomerId(int customerId) method");
        int CustomerId = 1;
        List<Building> result = buildingMapper.getAllBuildingsByCustomerId(CustomerId);

        for (Building building : result) {
            assertNotNull(building);
        }
    }

    /**
     * Test of deleteBuildingByBuildingId method, of class BuildingMapper.
     */
    @Test
    public void testDeleteBuildingByBuildingId() {
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

        buildingMapper.addBuilding(new Building(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId));
        int buildingId = buildingMapper.getBuildingIdByName(name);

        BuildingController buildingController = new BuildingController();
        buildingController.deleteBuildingByBuildingId(buildingId);

        Building building = buildingController.getBuildingByBuildingId(buildingId);

        assertTrue(building == null);
    }

    /**
     * Test of deleteBuildingByCustomerId method, of class BuildingMapper.
     */
    @Test
    public void testDeleteBuildingByCustomerId() {
        System.out.println("deleteBuildingByCustomerId");
        int customerId = 1;
        
        List<Building> buildings = buildingMapper.getAllBuildingsByCustomerId(customerId);
        for (Building building : buildings) {
            assertNotNull(building);
            new BuildingController().deleteBuildingByBuildingId(building.getBuildingId());
            assertNull(buildingMapper.getBuildingByBuildingId(building.getBuildingId()));
        }
    }

    /**
     * Test of getBuildingIdsByCustomerId method, of class BuildingMapper.
     */
    @Test
    public void testGetBuildingIdsByCustomerId() {
        System.out.println("getBuildingIdsByCustomerId");
        int customerId = 2;
        List<Integer> expResult = new ArrayList();
        expResult.add(2); expResult.add(3); expResult.add(4);
        List<Integer> result = buildingMapper.getBuildingIdsByCustomerId(customerId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBuildingByBuildingId method, of class BuildingMapper.
     */
    @Test
    public void testGetBuildingByBuildingId() {
        System.out.println("Testing the getBuildingByBuildingId(int buildingId) method");
        int buildingId = 5;

        assertNotNull(buildingMapper.getBuildingByBuildingId(buildingId));
    }

    /**
     * Test of getBuildingIdByName method, of class BuildingMapper.
     */
    @Test
    public void testGetBuildingIdByName() {
        System.out.println("getBuildingIdByName");
        String name = "Burj Al Arab";
        int expResult = 5;
        int result = buildingMapper.getBuildingIdByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfFloorsByBuildingId method, of class BuildingMapper.
     */
    @Test
    public void testGetNumberOfFloorsByBuildingId() {
        System.out.println("getNumberOfFloorsByBuildingId");
        int buildingId = 5;
        int expResult = 10;
        int result = buildingMapper.getNumberOfFloorsByBuildingId(buildingId);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateBuildingFloorsByBuildingId method, of class BuildingMapper.
     */
    @Test
    public void testUpdateBuildingFloorsByBuildingId() {
        System.out.println("updateBuildingFloorsByBuildingId");
        int buildingId = 6;
        int before = buildingMapper.getNumberOfFloorsByBuildingId(buildingId);
        new FloorMapper().addFloor(new Floor(3, 231, 6));
        buildingMapper.updateBuildingFloorsByBuildingId(buildingId);
        int after = buildingMapper.getNumberOfFloorsByBuildingId(buildingId);
        
        assertFalse(before == after);
        
    }

    /**
     * Test of editBuildingByBuildingId method, of class BuildingMapper.
     */
    @Test
    public void testEditBuildingByBuildingId() throws Exception {
        System.out.println("editBuildingByBuildingId");
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

        buildingMapper.addBuilding(new Building(nameBefore, addressBefore, zipcodesBefore, cityBefore, buildingYearBefore, floorsBefore, totalSizeBefore, buildingOwnerBefore, buildingConditionBefore, costumerIdBefore));
        int buildingId = buildingMapper.getBuildingIdByName(nameBefore);
        Building buildingBefore = buildingMapper.getBuildingByBuildingId(buildingId);

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

        buildingMapper.editBuildingByBuildingId(new Building(buildingId, nameAfter, addressAfter, zipcodesAfter, cityAfter, buildingYearAfter, floorsAfter, totalSizeAfter, buildingOwnerAfter, buildingConditionAfter));

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

}
