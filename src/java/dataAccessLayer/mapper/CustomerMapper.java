package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import exceptions.UserAlreadyExistsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import serviceLayer.entity.Customer;
import serviceLayer.entity.User;

public class CustomerMapper {

    //made by Lasse and Nicolai
    public void addCustomer(Customer customer, User user) {

        try {

            String query = "INSERT INTO customer (companyName, companyOwnerFirstName, companyOwnerLastName,  customerEmail, userId) VALUES (?,?,?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, customer.getCompanyName());
            ps.setString(2, customer.getCustomerFirstName());
            ps.setString(3, customer.getCustomerLastName());
            ps.setString(4, customer.getCustomerEmail());
            ps.setInt(5, user.getUserId());

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
                String customerFirstname = rs.getString("customerFirstName");
                String customerLastname = rs.getString("customerLastName");

                customer = new Customer(customerId, companyName, customerFirstname, customerLastname, customerEmail, userId);
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
}
