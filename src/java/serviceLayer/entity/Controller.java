package serviceLayer.entity;

import dataAccessLayer.mapper.BuildingMapper;
import dataAccessLayer.mapper.FloorMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Building;
import serviceLayer.entity.Floor;

public class Controller {
    
    Building currentBuilding = null;

    public Controller() {
    }
    
    public void addBuilding(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) throws SQLException, ClassNotFoundException{
        Building building = new Building(name, address, zipcodes, city, buildingYear, floors, totalSize,buildingOwner, buildingCondition,costumerId);
        currentBuilding = building;
        BuildingMapper buildingMapper = new BuildingMapper();
        buildingMapper.addBuilding(building);
    }
    
    public void addFloors(List<Floor> floors) {
        
        FloorMapper floorMapper = new FloorMapper();
        floorMapper.addFloors(floors);
        
        currentBuilding = null;
        
    }
    
    
}
