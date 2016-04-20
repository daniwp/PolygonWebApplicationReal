package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Building;

/**
 *
 * @author Daniel
 */
public class BuildingController {

    MapperFacade mapperFacade = new MapperFacade();

    // Creates a building and then inserts it into the database
    public void addBuilding(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) throws SQLException, ClassNotFoundException {
        Building building = new Building(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId);

        mapperFacade.addBuilding(building);
    }

    public void deleteBuildingByBuildingId(int buildingId) {
        mapperFacade.deleteFloorsByBuildingId(buildingId);
        mapperFacade.deleteBuildingByBuildingId(buildingId);
    }

    public int getBuildingIdByName(String name) {
        return mapperFacade.getBuildingIdByName(name);
    }

    public Building getBuildingByBuildingId(int buildingId) {
        Building building = new Building();
        building = mapperFacade.getBuildingByBuildingId(buildingId);
        return building;
    }

    public List<Building> getAllBuildingsByCustomerId(int CustomerId) {
        List<Building> buildings = mapperFacade.getAllBuildingsByCustomerId(CustomerId);
        return buildings;
    }

    public void updateBuildingFloorsByBuildingId(int buildingId) {
        mapperFacade.updateBuildingFloorsByBuildingId(buildingId);
    }
    
    public void editBuildingByBuildingId(Building building) throws SQLException {
        mapperFacade.editBuildingByBuildingId(building);
    }
    
}
