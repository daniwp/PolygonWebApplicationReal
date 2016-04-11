package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import exceptions.UserAlreadyExistsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Building;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Floor;
import serviceLayer.entity.User;

public class MapperFacade {

    BuildingMapper buildingMapper = new BuildingMapper();
    CustomerMapper customerMapper = new CustomerMapper();
    FloorMapper floorMapper = new FloorMapper();
    UserMapper userMapper = new UserMapper();

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

    public void addCustomer(Customer customer, User user) {
        customerMapper.addCustomer(customer, user);
    }

    public Customer getCustomerByUserId(int userId) {
        return customerMapper.getCustomerByUserId(userId);
    }

    public User validateUser(String username, String password) {
        return userMapper.validateUser(username, password);
    }

    public User checkIfUserExistsByUsername(String username) throws SQLException {
        return userMapper.checkIfUserExistsByUsername(username);
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        userMapper.addUser(user);
    }
}
