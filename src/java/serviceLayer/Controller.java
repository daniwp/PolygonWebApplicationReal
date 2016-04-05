package serviceLayer;

import dataAccessLayer.mapper.BuildingMapper;
import dataAccessLayer.mapper.CustomerMapper;
import dataAccessLayer.mapper.FloorMapper;
import dataAccessLayer.mapper.MapperFacade;
import exceptions.UserAlreadyExistsException;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Building;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Floor;

public class Controller {

    private static Building currentBuilding = null;
    private MapperFacade mapperFacade = new MapperFacade();

    public Controller() {
    }

    public Building getCurrentBuilding() {
        return currentBuilding;
    }

    public void setCurrentBuilding(Building currentBuilding) {
        this.currentBuilding = currentBuilding;
    }

    // Creates a building and then inserts it into the database
    public void addBuilding(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) throws SQLException, ClassNotFoundException {
        Building building = new Building(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId);

        setCurrentBuilding(building);
        mapperFacade.addBuilding(building);
    }

    //Takes a list of floor objects and adds them to the database
    public void addFloors(List<Floor> floors) {
        mapperFacade.addFloors(floors);
    }

    // creates a customer and inserts it into the database
    public void addCustomer(String companyName, String companyOwnerFirstName, String companyOwnerLastName, String customerUsername, String customerPassword, String customerEmail) throws SQLException, ClassNotFoundException, UserAlreadyExistsException {
        Customer customer = new Customer(companyName, companyOwnerFirstName, companyOwnerLastName, customerUsername, customerPassword, customerEmail);
        mapperFacade.addCustomer(customer);
    }

    public void deleteBuildingAndFloorsByBuildingId(int buildingId) {
        mapperFacade.deleteFloorsByBuildingId(buildingId);
        mapperFacade.deleteBuildingByBuildingId(buildingId);
    }
    
    public void validateLogin(String customerUsername, String customerPassword) {
        mapperFacade.validateLogin(customerUsername, customerPassword);
    }
}
