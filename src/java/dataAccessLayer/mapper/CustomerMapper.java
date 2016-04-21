package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Customer;

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
    
    // Daniel
    public Customer getCustomerByUserId(int userId) {
        Customer customer = null;

        try {
            String query = "SELECT (customerId, companyName, customerEmail, companyOwnerFirstName, companyOwnerLastName)"
                    + " FROM customer WHERE userId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

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

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList();
        
        try {

            String query = "SELECT (customerId, companyName, customerEmail, companyOwnerFirstName, companyOwnerLastName, userId) FROM customer ORDER BY (companyName)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int customerId = rs.getInt("customerId");
                String companyName = rs.getString("companyName");
                String customerEmail = rs.getString("customerEmail");
                String companyOwnerFirstName = rs.getString("companyOwnerFirstName");
                String companyOwnerLastName = rs.getString("companyOwnerLastName");
                int userId = rs.getInt("userId");

                Customer customer = new Customer(customerId, companyName, companyOwnerFirstName, companyOwnerLastName, customerEmail, userId);
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
        Customer customer = null;

        try {
            String query = "SELECT (companyName, customerEmail, companyOwnerFirstName, companyOwnerLastName, userId)"
                    + " FROM customer WHERE customerId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String companyName = rs.getString("companyName");
                String customerEmail = rs.getString("customerEmail");
                String customerFirstname = rs.getString("companyOwnerFirstName");
                String customerLastname = rs.getString("companyOwnerLastName");
                int userId = rs.getInt("userId");

                customer = new Customer(customerId, companyName, customerFirstname, customerLastname, customerEmail, userId);
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }

//made by Lasse
    public void deleteCustomerByCustomerId(int customerId, int userId) {
        
        try {
            String query = "DELETE FROM customer WHERE (customerId) = ? AND (userId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, customerId);
            ps.setInt(2, userId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    public int getUserIdByCustomerId(int customerId) {
        int userId = 0;

        try {
            String query = "SELECT (userId) FROM customer WHERE customerId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("userId");
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return userId;
    }

    public String getEmailById(int customerId) {
        String email = null;

        try {
            String query = "SELECT (customerEmail) FROM customer WHERE (customerId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                email = rs.getString("customerEmail");
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return email;
    }

    public void updateCustomer(Customer customer) throws SQLException {
        
        try {
            String query = "UPDATE customer SET companyName = ?, customerEmail = ?, companyOwnerFirstName = ?, companyOwnerLastName = ? WHERE customerId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setString(1, customer.getCompanyName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setString(3, customer.getCustomerFirstName());
            ps.setString(4, customer.getCustomerLastName());
            ps.setInt(5, customer.getCustomerId());
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }
}
