/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dataAccessLayer.mapper.MapperFacade;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import serviceLayer.entity.Building;

/**
 *
 * @author Daniel
 */
public class JUnitTest {

    @Test
    public void test() {
        
        MapperFacade mapperFacade = new MapperFacade();
        //Building expected = new Building("Trump Tower", "gade 123", 2980, "Kokkedal", 1999, 5, 200.5, "Trumpasd Inc.", 1, 1);
        String resultName = mapperFacade.getBuildingByBuildingId(1).getName();
        String expectedName = "Trump Tower";
        String resultAddress = mapperFacade.getBuildingByBuildingId(1).getAddress();
        String expectedAddress = "gade 123";
        int resultZipcode = mapperFacade.getBuildingByBuildingId(1).getZipcodes();
        int expectedZipcode = 2980;
        String resultCity = mapperFacade.getBuildingByBuildingId(1).getCity();
        String expectedCity = "Kokkedal";
        int resultYear = mapperFacade.getBuildingByBuildingId(1).getBuildingYear();
        int expectedYear = 1999;
        int resultFloors = mapperFacade.getBuildingByBuildingId(1).getFloors();
        int expectedFloors = 5;
        double resultSize = mapperFacade.getBuildingByBuildingId(1).getTotalSize();
        double expectedSize = 200.50;
        String resultOwner = mapperFacade.getBuildingByBuildingId(1).getBuildingOwner();
        String expectedOwner = "Trumpasd Inc.";
        int resultCondition = mapperFacade.getBuildingByBuildingId(1).getBuildingCondition();
        int expectedCondition = 1;
        int resultCID = mapperFacade.getBuildingByBuildingId(1).getCustomerId();
        int expectedCID = 1;

        assertEquals(expectedName, resultName);
        assertEquals(expectedAddress, resultAddress);
        assertEquals(expectedZipcode, resultZipcode);
        assertEquals(expectedCity, resultCity);
        assertEquals(expectedYear, resultYear);
        assertEquals(expectedFloors, resultFloors);
        assertEquals(expectedOwner, resultOwner);
        assertEquals(expectedCondition, resultCondition);
        assertEquals(expectedCID, resultCID);
        assertEquals(expectedSize, resultSize, 0.000001);

    }

}
