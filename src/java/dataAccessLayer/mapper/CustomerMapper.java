package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import exceptions.UserAlreadyExistsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import serviceLayer.entity.Customer;

public class CustomerMapper {

    //made by Lasse and Nicolai
    public void addCustomer(Customer c) throws UserAlreadyExistsException {

        try {
            
            if (checkIfCustomerExistsByUsername(c.getCustomerUsername()) != null) {
                System.out.println("DAFUQ");
                throw new UserAlreadyExistsException("A customer with that username already exists!");
            }
            
            String query = "INSERT INTO customer (companyName, companyOwnerFirstName, companyOwnerLastName, customerUsername, customerPassword, customerEmail) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, c.getCompanyName());
            ps.setString(2, c.getCustomerFirstName());
            ps.setString(3, c.getCustomerLastName());
            ps.setString(4, c.getCustomerUsername());
            ps.setString(5, c.getCustomerPassword());
            ps.setString(6, c.getCustomerEmail());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    public Customer validateLogin(String customerUsername, String customerPassword) {
        ResultSet rs = null;
        Customer customer = null;
        try {
            String query = "SELECT * FROM customer WHERE customerUsername = ? and customerPassword = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, customerUsername);
            ps.setString(2, customerPassword);

            rs = ps.executeQuery();

            if (rs.next()) {
                int customerId = rs.getInt("customerId");
                String companyName = rs.getString("companyName");
                String customerFirstname = rs.getString("companyOwnerFirstName");
                String customerLastname = rs.getString("companyOwnerLastName");
                String cUsername = rs.getString("customerUsername");
                String cPassword = rs.getString("customerPassword");
                String customerEmail = rs.getString("customerEmail");

                customer = new Customer(customerId, companyName, customerFirstname, customerLastname, customerUsername, customerPassword, customerEmail);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    // Daniel
    // Returns null if a user with the username already exists
    public Customer checkIfCustomerExistsByUsername(String username) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;

        try {
            String query = "SELECT * FROM customer WHERE customerUsername = ?";
            ps = DBConnector.getConnection().prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("DAFUQ2");
                customer = new Customer("", "", "", rs.getString("customerUsername"), "", "");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ps.close();
            rs.close();
        }
        return customer;
    }

}
