package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import serviceLayer.entity.Customer;

public class CustomerMapper {
    //made by Lasse and Nicolai
    public void addCustomer(Customer c)  {

        try {
            String query = "INSERT INTO customer (companyName, customerOwnerFirstName, customerOwnerLastName, customerUsername, customerPassword, customerEmail) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, c.getCompanyName());
            ps.setString(2, c.getCustomerFirstName());
            ps.setString(4, c.getCustomerLastName());
            ps.setString(5, c.getCustomerUsername());
            ps.setString(6, c.getCustomerPassword());
            ps.setString(7, c.getCustomerEmail());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            
        }
    }
}
