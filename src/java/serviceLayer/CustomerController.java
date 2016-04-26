/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import exceptions.UserAlreadyExistsException;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Customer;
import serviceLayer.entity.User;

/**
 *
 * @author Daniel
 */
public class CustomerController {

    MapperFacade mapperFacade = new MapperFacade();
    BuildingController buildingController = new BuildingController();
    
    public int getCustomerIdByBuildingId(int buildingId) {
        return mapperFacade.getBuildingByBuildingId(buildingId).getCustomerId();
    }

    public String getCustomerEmailById(int customerId) {
        return mapperFacade.getEmailById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return mapperFacade.getAllCustomers();
    }

    // Deletes every building owned by the customer and all files/floors attached to them before the customer and user is deleted
    public void deleteCustomerByCustomerId(int customerId) {
        int userId = mapperFacade.getUserIdByCustomerId(customerId);
        List<Integer> buildingIds = mapperFacade.getBuildingIdsByCustomerId(customerId);

        for (int buildingId : buildingIds) {
            buildingController.deleteBuildingByBuildingId(buildingId);
        }

        mapperFacade.deleteCustomerByCustomerId(customerId, userId);
        mapperFacade.deleteUserByUserId(userId);
    }

    public Customer getCustomerByCustomerId(int customerId) {
        return mapperFacade.getCustomerByCustomerId(customerId);
    }

    public void addCustomer(String companyName, String companyOwnerFirstName, String companyOwnerLastName, String customerEmail, int userId) throws SQLException, ClassNotFoundException, UserAlreadyExistsException {
        Customer customer = new Customer(companyName, companyOwnerFirstName, companyOwnerLastName, customerEmail, userId);
        mapperFacade.addCustomer(customer);
    }
    
    // Adds a user and the a customer with the created users ID
    public void addCustomer(String companyName, String customerFirstName, String customerLastName, String customerEmail, String username, String password, int type) throws UserAlreadyExistsException {
        User user = new User(username, password, type);
        mapperFacade.addUser(user);
        int userId = mapperFacade.getUserIdByUsername(username);
        Customer customer = new Customer(companyName, customerFirstName, customerLastName, customerEmail, userId);
        mapperFacade.addCustomer(customer);
    }
    
    public void updateCustomer(int customerId, String companyName, String customerFirstName, String customerLastName, String customerEmail) throws SQLException {
        Customer customer = new Customer (customerId, companyName, customerFirstName, customerLastName, customerEmail);
        mapperFacade.updateCustomer(customer);
    }

}
