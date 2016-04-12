package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import exceptions.UserAlreadyExistsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import serviceLayer.entity.Customer;
import serviceLayer.entity.User;

public class CustomerMapper {

    //made by Lasse and Nicolai
    public void addCustomer(Customer customer) {

        try {

            String query = "INSERT INTO customer (companyName, companyOwnerFirstName, companyOwnerLastName,  customerEmail, userId) VALUES (?,?,?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, customer.getCompanyName());
            ps.setString(2, customer.getCustomerFirstName());
            ps.setString(3, customer.getCustomerLastName());
            ps.setString(4, customer.getCustomerEmail());
            ps.setInt(5, customer.getUserId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    public Customer getCustomerByUserId(int userId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;

        try {
            String query = "SELECT * FROM customer WHERE userId = ?";
            ps = DBConnector.getConnection().prepareStatement(query);
            ps.setInt(1, userId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int customerId = rs.getInt("customerId");
                String companyName = rs.getString("companyName");
                String customerEmail = rs.getString("customerEmail");
                String customerFirstname = rs.getString("companyOwnerFirstName");
                String customerLastname = rs.getString("companyOwnerLastName");

                customer = new Customer(customerId, companyName, customerFirstname, customerLastname, customerEmail, userId);
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
    
    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList();
        Customer customer;
        ResultSet rs = null;
        try {
            
            String query = "Select * FROM customer";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
            int customerId = rs.getInt("customerId");
            String companyName = rs.getString("companyName");
            String customerEmail = rs.getString("customerEmail");
            String companyOwnerFirstName = rs.getString("companyOwnerFirstName");
            String companyOwnerLastName = rs.getString("companyOwnerLastName");
            int userId = rs.getInt("userId");
            
            customer = new Customer(customerId, companyName, customerEmail, companyOwnerFirstName, companyOwnerLastName, userId);
            customers.add(customer);
            
            }
            ps.close();
            rs.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customers;
        
    }
        public Customer getCustomerByCustomerId(int customerId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;

        try {
            String query = "SELECT * FROM customer WHERE customerId = ?";
            ps = DBConnector.getConnection().prepareStatement(query);
            ps.setInt(1, customerId);

            rs = ps.executeQuery();

            while (rs.next()) {
                String companyName = rs.getString("companyName");
                String customerEmail = rs.getString("customerEmail");
                String customerFirstname = rs.getString("companyOwnerFirstName");
                String customerLastname = rs.getString("companyOwnerLastName");

                customer = new Customer(customerId, companyName, customerFirstname, customerLastname, customerEmail);
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
}
