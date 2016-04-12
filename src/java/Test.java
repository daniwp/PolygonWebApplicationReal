
import dataAccessLayer.mapper.CustomerMapper;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nicolai
 */
public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CustomerMapper cM = new CustomerMapper();
        List<Customer> customers = cM.getAllCustomers();
        
        for (Customer c : customers) {
            System.out.println("Name: " + c.getCompanyName());
            System.out.println("Email: " + c.getCustomerEmail());
            System.out.println("Firstname: " + c.getCustomerFirstName());
            System.out.println("Lastname: " + c.getCustomerLastName());
        }
    }
}
