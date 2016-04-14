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
import serviceLayer.entity.Report;
import serviceLayer.entity.User;

public class MapperFacade {

    BuildingMapper buildingMapper = new BuildingMapper();
    CustomerMapper customerMapper = new CustomerMapper();
    FloorMapper floorMapper = new FloorMapper();
    UserMapper userMapper = new UserMapper();
    ReportMapper reportMapper = new ReportMapper();
    DocumentMapper documentMapper = new DocumentMapper();

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

    public OutputStream downloadReport(ServletContext context, HttpServletResponse response, int reportId) throws ClassNotFoundException {
        return reportMapper.downloadReport(context, response, reportId);
    }

    public void saveDocument(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        documentMapper.saveDocument(input, name, date, buildingId);
    }

    public List<Document> getAllDocumentsByBuildingId(int buildingId) {
        return documentMapper.getAllDocumentsByBuildingId(buildingId);
    }

    public OutputStream downloadDocument(ServletContext context, HttpServletResponse response, int documentId) throws ClassNotFoundException {
        return documentMapper.downloadDocument(context, response, documentId);
    }
    
    public void deleteReportByReportId(int reportId) {
        reportMapper.deleteReportByReportId(reportId);
    }
}
