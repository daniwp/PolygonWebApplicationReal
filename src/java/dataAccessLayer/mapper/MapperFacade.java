package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import exceptions.UserAlreadyExistsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Building;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Floor;

public class MapperFacade {

    BuildingMapper buildingMapper = new BuildingMapper();
    CustomerMapper customerMapper = new CustomerMapper();
    FloorMapper floorMapper = new FloorMapper();

    public void addBuilding(Building b) {
        buildingMapper.addBuilding(b);
    }

    public List<Building> getAllBuildingsByCustomerId(int customerId) {
        return buildingMapper.getAllBuildingsByCustomerId(customerId);
    }

    //made by Lasse
    public void deleteBuildingByBuildingId(int buildingId) {
        buildingMapper.deleteBuildingByBuildingId(buildingId);
    }

    // Daniel
    public Building getBuildingByBuildingId(int buildingId) {
        return buildingMapper.getBuildingByBuildingId(buildingId);
    }

    public int getBuildingIdByName(String name) {
        return buildingMapper.getBuildingIdByName(name);
    }
    
    public void updateBuildingFloorsByBuildingId(int buildingId) {
        buildingMapper.updateBuildingFloorsByBuildingId(buildingId);
    }

    public boolean addFloor(Floor floor) {
        return floorMapper.addFloor(floor);
    }

    //Made by Nicolai
    public void deleteFloorsByBuildingId(int buildingId) {
        floorMapper.deleteFloorsByBuildingId(buildingId);
    }

    public List<Floor> getAllFloorsByBuildingID(int buildingId) {
        return floorMapper.getAllFloorsByBuildingID(buildingId);
    }

    public void deleteFloorByFloorId(int floorId) {
        floorMapper.deleteFloorByFloorId(floorId);
    }

    public void addCustomer(Customer c) throws UserAlreadyExistsException {
        customerMapper.addCustomer(c);
    }

    public Customer validateLogin(String customerUsername, String customerPassword) {
        return customerMapper.validateLogin(customerUsername, customerPassword);
    }
}
