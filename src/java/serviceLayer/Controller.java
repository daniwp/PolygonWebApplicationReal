package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import exceptions.UserAlreadyExistsException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import serviceLayer.entity.Building;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Floor;
import serviceLayer.entity.User;

public class Controller {

    private MapperFacade mapperFacade = new MapperFacade();

    public Controller() {
    }

    public void addUserAndCustomer(String companyName, String customerFirstName, String customerLastName, String customerEmail, String username, String password, int type) throws UserAlreadyExistsException {
        User user = new User(username, password, type);
        mapperFacade.addUser(user);
        int userId = mapperFacade.getUserIdByUsername(username);
        Customer customer = new Customer(companyName, customerFirstName, customerLastName, customerEmail, userId);
        mapperFacade.addCustomer(customer);
    }

    // Creates a building and then inserts it into the database
    public void addBuilding(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) throws SQLException, ClassNotFoundException {
        Building building = new Building(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId);

        mapperFacade.addBuilding(building);
    }

    //Takes a list of floor objects and adds them to the database
    public void addFloor(int floorNumber, double size, int buildingId) {
        Floor floor = new Floor(floorNumber, size, buildingId);
        mapperFacade.addFloor(floor);
    }

    // creates a customer and inserts it into the database
    public void addCustomer(String companyName, String companyOwnerFirstName, String companyOwnerLastName, String customerEmail, int userId) throws SQLException, ClassNotFoundException, UserAlreadyExistsException {
        Customer customer = new Customer(companyName, companyOwnerFirstName, companyOwnerLastName, customerEmail, userId);
        mapperFacade.addCustomer(customer);
    }

    public void deleteBuildingAndFloorsByBuildingId(int buildingId) {
        mapperFacade.deleteFloorsByBuildingId(buildingId);
        mapperFacade.deleteBuildingByBuildingId(buildingId);
    }

    public boolean validateLogin(String customerUsername, String customerPassword, HttpSession curSession) {
        User user = mapperFacade.validateUser(customerUsername, customerPassword);
        user.setUserId(mapperFacade.getUserIdByUsername(customerUsername));
        Customer customer = mapperFacade.getCustomerByUserId(user.getUserId());

        if (user != null) {
            curSession.setAttribute("loggedIn", true);
            if (user.getType() == 1) {
                curSession.setAttribute("customer", customer);
            } else if (user.getType() == 0) {
                curSession.setAttribute("admin", true);
            }
            return true;
        } else {
            curSession.setAttribute("loginError", "An error occurred. Please try again.");
            return false;
        }
    }

    public int getBuildingIdByName(String name) {
        return mapperFacade.getBuildingIdByName(name);
    }

    public Building getBuildingByBuildingId(int buildingId) {
        Building building = new Building();
        building = mapperFacade.getBuildingByBuildingId(buildingId);
        return building;
    }
    public Customer getCustomerByCustomerId(int customerId) {
      Customer customer = new Customer();
      customer = mapperFacade.getCustomerByCustomerId(customerId);
      return customer;
    }

    public List<Building> getAllBuildingsByCustomerId(int CustomerId) {
        List<Building> buildings = mapperFacade.getAllBuildingsByCustomerId(CustomerId);
        return buildings;
    }

    public void deleteFloorByFloorId(int floorId) {
        mapperFacade.deleteFloorByFloorId(floorId);
    }

    public List<Floor> getAllFloorsByBuildingId(int buildingId) {
        List<Floor> floors = mapperFacade.getAllFloorsByBuildingID(buildingId);
        return floors;
    }

    public void updateNumberOfFloorsByBuildingId(int buildingId) {
        mapperFacade.updateBuildingFloorsByBuildingId(buildingId);
    }
    
    public void addUser(String username, String password, int type) throws UserAlreadyExistsException {
        User user = new User(username, password, type);
        mapperFacade.addUser(user);
    }
    
    public List<Customer> getAllCustomers(){
       return mapperFacade.getAllCustomers();
    }
}
