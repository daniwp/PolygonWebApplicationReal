package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Building;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Floor;

/**
 *
 * @author danie
 */
public class MapperFacade {

    BuildingMapper buildingMapper = new BuildingMapper();
    CustomerMapper customerMapper = new CustomerMapper();
    FloorMapper floorMapper = new FloorMapper();

    public void addBudilding(Building b) {
        buildingMapper.addBuilding(b);
    }

    public List<Building> getAllBuildings(int customerId) {
        return buildingMapper.getAllBuildings(customerId);
    }

    //made by Lasse
    public void deleteBuildingByBuildingId(int buildingId) {
        buildingMapper.deleteBuildingByBuildingId(buildingId);
    }

    // Daniel
    public Building getBuildingByBuildingId(int buildingId) {
        return buildingMapper.getBuildingByBuildingId(buildingId);
    }

    public boolean addFloors(List<Floor> floors) {
        return floorMapper.addFloors(floors);
    }

    //Made by Nicolai
    public void deleteFloorsByBuildingId(int buildingId) {
        floorMapper.deleteFloorsByBuildingId(buildingId);
    }

    public List<Floor> getAllFloorsByBuildingID(int buildingId) {
        return floorMapper.getAllFloorsByBuildingID(buildingId);
    }

    public void addCustomer(Customer c) {
        customerMapper.addCustomer(c);
    }

    public Customer validateLogin(String customerUsername, String customerPassword) {
        return customerMapper.validateLogin(customerUsername, customerPassword);
    }
}
