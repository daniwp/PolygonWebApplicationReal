package serviceLayer.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Customer {

    private int customerId;
    private String companyName;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private int userId;

    public Customer(int customerId, String companyName, String customerFirstName, String customerLastName, String customerEmail, int userId) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.userId = userId;
    }

    public Customer(String companyName, String customerFirstName, String customerLastName, String customerEmail, int userId) {
        this.companyName = companyName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.userId = userId;
    }

    public Customer(int customerId, String companyName, String customerFirstName, String customerLastName, String customerEmail) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
    }
    
    public Customer() {
    }

    public int getUserId() {
        return userId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}
