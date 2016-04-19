package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import exceptions.UserAlreadyExistsException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import serviceLayer.entity.Building;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Document;
import serviceLayer.entity.Floor;
import serviceLayer.entity.Floorplan;
import serviceLayer.entity.Image;
import serviceLayer.entity.Report;
import serviceLayer.entity.User;
import serviceLayer.entity.Checkup;

public class MapperFacade {

    BuildingMapper buildingMapper = new BuildingMapper();
    CustomerMapper customerMapper = new CustomerMapper();
    FloorMapper floorMapper = new FloorMapper();
    UserMapper userMapper = new UserMapper();
    ReportMapper reportMapper = new ReportMapper();
    DocumentMapper documentMapper = new DocumentMapper();
    FloorplanMapper floorplanMapper = new FloorplanMapper();
    ImageMapper imageMapper = new ImageMapper();
    CheckupMapper checkupMapper = new CheckupMapper();

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

    public void addFloor(Floor floor) {
        floorMapper.addFloor(floor);
    }

    public boolean checkIfFloorExists(int buildingId, int floorNumber) {
        return floorMapper.checkIfFloorExists(buildingId, floorNumber);
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

    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    public Customer getCustomerByCustomerId(int customerId) {
        return customerMapper.getCustomerByCustomerId(customerId);
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

    public int getUserIdByUsername(String username) {
        return userMapper.getUserIdByUsername(username);
    }

    public List<Customer> getAllCustomers() {
        return customerMapper.getAllCustomers();
    }

    public void deleteCustomerByCustomerId(int customerId, int userId) {
        customerMapper.deleteCustomerByCustomerId(customerId, userId);
    }

    public int getUserIdByCustomerId(int customerId) {
        return customerMapper.getUserIdByCustomerId(customerId);
    }

    public void deleteUserByUserId(int userId) {
        userMapper.deleteUserByUserId(userId);
    }

    public List<Integer> getBuildingIdsByCustomerId(int customerId) {
        return buildingMapper.getBuildingIdsByCustomerId(customerId);
    }

    public void saveReport(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        reportMapper.saveReport(input, name, date, buildingId);
    }

    public List<Report> getAllReportsByBuildingId(int buildingId) {
        return reportMapper.getAllReportsByBuildingId(buildingId);
    }

    public InputStream downloadReport(int reportId) {
        return reportMapper.downloadReport(reportId);
    }

    public void saveDocument(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        documentMapper.saveDocument(input, name, date, buildingId);
    }

    public List<Document> getAllDocumentsByBuildingId(int buildingId) {
        return documentMapper.getAllDocumentsByBuildingId(buildingId);
    }

    public InputStream downloadDocument(int documentId) {
        return documentMapper.downloadDocument(documentId);
    }

    public String getDocumentNameById(int documentId) {
        return documentMapper.getDocumentNameById(documentId);
    }

    public void deleteReportByReportId(int reportId) {
        reportMapper.deleteReportByReportId(reportId);
    }

    public void deleteFloorplanByFloorplanId(int floorplanId) {
        floorplanMapper.deleteFloorplanByFloorplanId(floorplanId);
    }

    public Floorplan getFloorplanByFloorId(int floorId) {
        return floorplanMapper.getFloorplanByFloorId(floorId);
    }

    public InputStream downloadFloorplan(int floorplanId) {
        return floorplanMapper.downloadFloorplan(floorplanId);
    }

    public void uploadFloorplan(InputStream input, String name, int floorId) {
        floorplanMapper.uploadFloorplan(input, name, floorId);
    }

    public String getReportNameById(int reportId) {
        return reportMapper.getReportNameById(reportId);
    }

    public String getFloorplanNameById(int floorplanId) {
        return floorplanMapper.getFloorplanNameById(floorplanId);
    }

    public void deleteDocumentByDocumentId(int documentId) {
        documentMapper.deleteDocumentByDocumentId(documentId);
    }

    public void saveImage(InputStream inputStream, String name, int buildingId) throws ClassNotFoundException {
        imageMapper.saveImage(inputStream, name, buildingId);
    }

    public List<Image> getAllImagesByBuildingId(int buildingId) {
        return imageMapper.getAllImagesByBuildingId(buildingId);
    }

    public InputStream downloadImage(int imageId) throws ClassNotFoundException {
        return imageMapper.downloadImage(imageId);
    }

    public void deleteImageByImageId(int imageId) {
        imageMapper.deleteImageByImageId(imageId);
    }

    public String getImageNameById(int imageId) {
        return imageMapper.getImageNameById(imageId);
    }
    
    public void updateCheckupStatusById(int CheckupId, String Status) {
        checkupMapper.updateCheckupStatusById(CheckupId, Status);
    }
    
    public List<Checkup> getAllCheckupsByBuildingId(int buildingId) {
        return checkupMapper.getAllCheckupsByBuildingId(buildingId);
    }
    
    public Checkup getCheckupById(int checkupId) {
        return checkupMapper.getCheckupById(checkupId);
    }
    
    public void createNewCheckup(Checkup checkup) {
        checkupMapper.createNewCheckup(checkup);
    }
    
    public void deleteCheckupById(int checkupId) {
        checkupMapper.deleteCheckupById(checkupId);
    }
    
    public String getEmailById(int customerId) {
        return customerMapper.getEmailById(customerId);
    }
}
