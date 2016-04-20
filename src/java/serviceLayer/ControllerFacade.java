package serviceLayer;

import exceptions.FloorAlreadyExistsException;
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
import serviceLayer.entity.Document;
import serviceLayer.entity.Floor;
import serviceLayer.entity.Floorplan;
import serviceLayer.entity.Image;
import serviceLayer.entity.User;
import serviceLayer.entity.Checkup;
import serviceLayer.entity.PendingCheckup;

/**
 *
 * @author Daniel
 */
public class ControllerFacade {

    BuildingController buildingController = new BuildingController();
    CheckupController checkupController = new CheckupController();
    CustomerController customerController = new CustomerController();
    DocumentController documentController = new DocumentController();
    FloorController floorController = new FloorController();
    ImageController imageController = new ImageController();
    ReportController reportController = new ReportController();
    UserController userController = new UserController();
    FloorplanController floorplanController = new FloorplanController();

    public List<PendingCheckup> getAllPendingCheckups() {
        return checkupController.getAllPendingCheckups();
    }
    
    public void addBuilding(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) throws SQLException, ClassNotFoundException {
        buildingController.addBuilding(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId);
    }

    //Takes a list of floor objects and adds them to the database
    public void addFloor(int floorNumber, double size, int buildingId) throws FloorAlreadyExistsException {
        floorController.addFloor(floorNumber, size, buildingId);
    }
    
    // creates a customer and inserts it into the database
    public void addCustomer(String companyName, String companyOwnerFirstName, String companyOwnerLastName, String customerEmail, int userId) throws SQLException, ClassNotFoundException, UserAlreadyExistsException {
        customerController.addCustomer(companyName, companyOwnerFirstName, companyOwnerLastName, customerEmail, userId);
    }

    public void addCustomer(String companyName, String customerFirstName, String customerLastName, String customerEmail, String username, String password, int type) throws UserAlreadyExistsException {
        customerController.addCustomer(companyName, customerFirstName, customerLastName, customerEmail, username, password, type);
    }

    public void deleteBuildingAndFloorsByBuildingId(int buildingId) {
        buildingController.deleteBuildingByBuildingId(buildingId);
    }

    public boolean validateLogin(String customerUsername, String customerPassword, HttpSession curSession) {
        return userController.validateLogin(customerUsername, customerPassword, curSession);
    }
    
    public int getBuildingIdByName(String name) {
        return buildingController.getBuildingIdByName(name);
    }

    public Building getBuildingByBuildingId(int buildingId) {
        return buildingController.getBuildingByBuildingId(buildingId);
    }

    public List<Building> getAllBuildingsByCustomerId(int CustomerId) {
        return buildingController.getAllBuildingsByCustomerId(CustomerId);
    }

    public void deleteFloorByFloorId(int floorId) {
        floorController.deleteFloorByFloorId(floorId);
    }

    public List<Floor> getAllFloorsByBuildingId(int buildingId) {
        return floorController.getAllFloorsByBuildingId(buildingId);
    }

    public void updateBuildingFloorsByBuildingId(int buildingId) {
        buildingController.updateBuildingFloorsByBuildingId(buildingId);
    }

    public void addUser(String username, String password, int type) throws UserAlreadyExistsException {
        userController.addUser(username, password, type);
    }

    public List<Customer> getAllCustomers() {
        return customerController.getAllCustomers();
    }

    public Customer getCustomerByCustomerId(int customerId) {
        return customerController.getCustomerByCustomerId(customerId);
    }

    public void deleteCustomerByCustomerId(int customerId) {
        customerController.deleteCustomerByCustomerId(customerId);
    }

    public void saveReport(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        reportController.saveReport(input, name, date, buildingId);
    }

    public List<Report> getAllReportsByBuildingId(int buildingId) {
        return reportController.getAllReportsByBuildingId(buildingId);
    }

    public InputStream downloadReport(int reportId) throws ClassNotFoundException {
        return reportController.downloadReport(reportId);
    }

    public void saveDocument(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        documentController.saveDocument(input, name, date, buildingId);
    }

    public List<Document> getAllDocumentsByBuildingId(int buildingId) {
        return documentController.getAlDocumentsByBuildingId(buildingId);
    }

    public InputStream downloadDocument(int documentId) throws ClassNotFoundException {
        return documentController.downloadDocument(documentId);
    }

    public String getDocumentNameById(int documentId) {
        return documentController.getDocumentNameById(documentId);
    }

    public void deleteReportByReportId(int reportId) {
        reportController.deleteReportByReportId(reportId);
    }

    public void deleteFloorplanByFloorplanId(int floorplanId) {
        floorplanController.deleteFloorplanByFloorplanId(floorplanId);
    }

    public Floorplan getFloorplanByFloorId(int floorId) {
        return floorplanController.getFloorplanByFloorId(floorId);
    }

    public InputStream downloadFloorplan(int floorplanId) {
        return floorplanController.downloadFloorplan(floorplanId);
    }

    public void uploadFloorplan(InputStream input, String name, int floorId) {
        floorplanController.uploadFloorplan(input, name, floorId);
    }

    public String getReportNameById(int reportId) {
        return reportController.getReportNameById(reportId);
    }

    public String getFloorplanNameById(int floorplanId) {
        return floorplanController.getFloorplanNameById(floorplanId);
    }

    public void deleteDocumentByDocumentId(int documentId) {
        documentController.deleteDocumentByDocumentId(documentId);
    }

    public void saveImage(InputStream inputStream, String name, int buildingId) throws ClassNotFoundException {
        imageController.saveImage(inputStream, name, buildingId);
    }
    
    public List<Image> getAllImagesByBuildingId(int buildingId) {
        return imageController.getAllImagesByBuildingId(buildingId);
    }

    public InputStream downloadImage(int imageId) throws ClassNotFoundException {
        return imageController.downloadImage(imageId);
    }

    public void deleteImageByImageId(int imageId) {
        imageController.deleteImageByImageId(imageId);
    }

    public String getImageNameById(int imageId) {
        return imageController.getImageNameById(imageId);
    }
    
    public void updateCheckupsStatusById(int checkupId, String Status) {
        checkupController.updateCheckupsStatusById(checkupId, Status);
    }
    
    public List<Checkup> getAllCheckupsByBuildingId(int buildingId) {
        return checkupController.getAllCheckupsByBuildingId(buildingId);
    }
    
    public Checkup getCheckupById(int checkupId) {
        return checkupController.getCheckupById(checkupId);
    }
    
    public void createNewCheckup(String status,String date, String email, int buildingId) {
        Checkup checkup = new Checkup();
        checkupController.createNewCheckup(status, date, email, buildingId);
    }
    
    public void deleteCheckupById(int checkupId) {
        checkupController.deleteCheckupById(checkupId);
    }
    
    public String getCustomerEmailById(int customerId) {
        return customerController.getCustomerEmailById(customerId);
    }
    
    public void editBuildingByBuildingId(Building building) throws SQLException {
        buildingController.editBuildingByBuildingId(building);
    }
}
