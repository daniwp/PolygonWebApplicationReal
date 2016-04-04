package serviceLayer;

import dataAccessLayer.mapper.BuildingMapper;
import dataAccessLayer.mapper.CustomerMapper;
import dataAccessLayer.mapper.FloorMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Building;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Floor;

public class Controller {
    
    Building currentBuilding = null;

    public Controller() {
    }
    
    // Creates a building and then inserts it into the database
    public void addBuilding(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) throws SQLException, ClassNotFoundException{
        Building building = new Building(name, address, zipcodes, city, buildingYear, floors, totalSize,buildingOwner, buildingCondition,costumerId);
        currentBuilding = building;
        BuildingMapper buildingMapper = new BuildingMapper();
        buildingMapper.addBuilding(building);
    }
    
    //Takes a list of floor objects and adds them to the database
    public void addFloors(List<Floor> floors) {
        FloorMapper floorMapper = new FloorMapper();
        floorMapper.addFloors(floors);
        
        currentBuilding = null;
    }
    // creates a customer and inserts it into the database
    public void addCustomer(String companyName, String firstName, String lastName, String userName, String passWord, String customerEmail)throws SQLException, ClassNotFoundException{
        Customer customer = new Customer(companyName, firstName, lastName, userName, passWord, customerEmail);
        CustomerMapper customerMapper = new CustomerMapper();
        customerMapper.addCustomer(customer);
        
    }
}
