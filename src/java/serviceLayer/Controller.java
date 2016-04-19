package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import exceptions.FloorAlreadyExistsException;
import exceptions.UserAlreadyExistsException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import serviceLayer.entity.Building;
import serviceLayer.entity.Report;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Document;
import serviceLayer.entity.Floor;
import serviceLayer.entity.Floorplan;
import serviceLayer.entity.Image;
import serviceLayer.entity.User;
import serviceLayer.entity.Checkup;

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
    public void addFloor(int floorNumber, double size, int buildingId) throws FloorAlreadyExistsException {
        if (mapperFacade.checkIfFloorExists(buildingId, floorNumber)) {
            throw new FloorAlreadyExistsException("Some floors were not added, as one or more floors already exists");
        } else {
            Floor floor = new Floor(floorNumber, size, buildingId);
            mapperFacade.addFloor(floor);
        }
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
        return mapperFacade.getCustomerByCustomerId(customerId);
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

    public List<Customer> getAllCustomers() {
        return mapperFacade.getAllCustomers();
    }

    public void deleteUserAndCustomerByCustomerId(int customerId) {
        int userId = mapperFacade.getUserIdByCustomerId(customerId);
        List<Integer> buildingIds = mapperFacade.getBuildingIdsByCustomerId(customerId);

        for (int buildingId : buildingIds) {
            deleteBuildingAndFloorsByBuildingId(buildingId);
        }

        mapperFacade.deleteCustomerByCustomerId(customerId, userId);
        mapperFacade.deleteUserByUserId(userId);
    }

    public void saveReport(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        mapperFacade.saveReport(input, name, date, buildingId);
    }

    public List<Report> getAllReportsByBuildingId(int buildingId) {
        return mapperFacade.getAllReportsByBuildingId(buildingId);
    }

    public InputStream downloadReport(int reportId) throws ClassNotFoundException {
        return mapperFacade.downloadReport(reportId);
    }

    public void saveDocument(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        mapperFacade.saveDocument(input, name, date, buildingId);
    }

    public List<Document> getAlDocumentsByBuildingId(int buildingId) {
        return mapperFacade.getAllDocumentsByBuildingId(buildingId);
    }

    public InputStream downloadDocument(int documentId) {
        return mapperFacade.downloadDocument(documentId);
    }

    public String getDocumentNameById(int documentId) {
        return mapperFacade.getDocumentNameById(documentId);
    }
    
    public void deleteReportByReportId(int reportId) {
        mapperFacade.deleteReportByReportId(reportId);
    }

    public void deleteFloorplanByFloorplanId(int floorplanId) {
        mapperFacade.deleteFloorplanByFloorplanId(floorplanId);
    }

    public Floorplan getFloorplanByFloorId(int floorId) {
        return mapperFacade.getFloorplanByFloorId(floorId);
    }

    public InputStream downloadFloorplan(int floorplanId) {
        return mapperFacade.downloadFloorplan(floorplanId);
    }

    public void uploadFloorplan(InputStream input, String name, int floorId) {
        mapperFacade.uploadFloorplan(input, name, floorId);
    }
    
    public String getReportNameById(int reportId) {
        return mapperFacade.getReportNameById(reportId);
    }
    
    public String getFloorplanNameById(int floorplanId) {
        return mapperFacade.getFloorplanNameById(floorplanId);
    }
    
    public void deleteDocumentByDocumentId(int documentId) {
        mapperFacade.deleteDocumentByDocumentId(documentId);
    }
    
    public void saveImage(InputStream inputStream, String name, int buildingId) throws ClassNotFoundException {
        mapperFacade.saveImage(inputStream, name, buildingId);
    }

    public List<Image> getAllImagesByBuildingId(int buildingId) {
        return mapperFacade.getAllImagesByBuildingId(buildingId);
    }

    public InputStream downloadImage(int imageId) throws ClassNotFoundException {
        return mapperFacade.downloadImage(imageId);
    }

    public void deleteImageByImageId(int imageId) {
        mapperFacade.deleteImageByImageId(imageId);
    }

    public String getImageNameById(int imageId) {
        return mapperFacade.getImageNameById(imageId);
    }
    
    public void updateCheckupsStatusById(int checkupId, String status) {
        mapperFacade.updateCheckupStatusById(checkupId, status);
    }
    
    public void createNewCheckup(int checkupId, String status, String date, String email, int buildingId) {
        Checkup checkup = new Checkup(status, date, email, buildingId);
        mapperFacade.createNewCheckup(checkup);
    }
    
    public List<Checkup> getAllCheckupsByBuildingId(int buildingId) {
        return mapperFacade.getAllCheckupsByBuildingId(buildingId);
    }
    
    public void deleteCheckupById(int checkupId) {
        mapperFacade.deleteCheckupById(checkupId);
    }
    
    public Checkup getCheckupById(int CheckupId) {
        return mapperFacade.getCheckupById(CheckupId);
    }
    
}
