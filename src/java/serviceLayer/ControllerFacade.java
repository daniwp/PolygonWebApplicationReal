package serviceLayer;

import exceptions.UserAlreadyExistsException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import serviceLayer.entity.Report;
import serviceLayer.entity.Building;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Floor;
import serviceLayer.entity.User;


/**
 *
 * @author Daniel
 */
public class ControllerFacade {

    Controller controller = new Controller();

    public void addBuilding(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) throws SQLException, ClassNotFoundException {
        controller.addBuilding(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId);
    }

    //Takes a list of floor objects and adds them to the database
    public void addFloor(int floorNumber, double size, int buildingId) {
        controller.addFloor(floorNumber, size, buildingId);
    }

    // creates a customer and inserts it into the database
    public void addCustomer(String companyName, String companyOwnerFirstName, String companyOwnerLastName, String customerEmail, int userId) throws SQLException, ClassNotFoundException, UserAlreadyExistsException {
        controller.addCustomer(companyName, companyOwnerFirstName, companyOwnerLastName, customerEmail, userId);
    }

    public void addUserAndCustomer(String companyName, String customerFirstName, String customerLastName, String customerEmail, String username, String password, int type) throws UserAlreadyExistsException {
        controller.addUserAndCustomer(companyName, customerFirstName, customerLastName, customerEmail, username, password, type);
    }

    public void deleteBuildingAndFloorsByBuildingId(int buildingId) {
        controller.deleteBuildingAndFloorsByBuildingId(buildingId);
    }

    public boolean validateLogin(String customerUsername, String customerPassword, HttpSession curSession) {
        return controller.validateLogin(customerUsername, customerPassword, curSession);
    }

    public int getBuildingIdByName(String name) {
        return controller.getBuildingIdByName(name);
    }

    public Building getBuildingByBuildingId(int buildingId) {
        return controller.getBuildingByBuildingId(buildingId);
    }

    public List<Building> getAllBuildingsByCustomerId(int CustomerId) {
        return controller.getAllBuildingsByCustomerId(CustomerId);
    }

    public void deleteFloorByFloorId(int floorId) {
        controller.deleteFloorByFloorId(floorId);
    }

    public List<Floor> getAllFloorsByBuildingId(int buildingId) {
        return controller.getAllFloorsByBuildingId(buildingId);
    }

    public void updateNumberOfFloorsByBuildingId(int buildingId) {
        controller.updateNumberOfFloorsByBuildingId(buildingId);
    }

    public void addUser(String username, String password, int type) throws UserAlreadyExistsException {
        controller.addUser(username, password, type);
    }

    public List<Customer> getAllCustomers() {
        return controller.getAllCustomers();
    }

    public Customer getCustomerByCustomerId(int customerId) {
        return controller.getCustomerByCustomerId(customerId);
    }

    public void deleteUserAndCustomerByCustomerId(int customerId) {
        controller.deleteUserAndCustomerByCustomerId(customerId);
    }

    public void saveReport(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        controller.saveReport(input, name, date, buildingId);
    }

    public List<Report> getAllReportsByBuildingId(int buildingId) {
        return controller.getAllReportsByBuildingId(buildingId);
    }

    public OutputStream downloadReport(ServletContext context, HttpServletResponse response, int reportId) throws ClassNotFoundException {
        return controller.downloadReport(context, response, reportId);
    }
}
