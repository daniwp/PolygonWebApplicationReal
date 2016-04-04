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
    private String customerUsername;
    private String customerPassword;

    public Customer(int customerId, String companyName, String customerFirstName, String customerLastName, String customerUsername, String customerPassword) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
    }

    public Customer(String companyName, String customerFirstName, String customerLastName, String customerUsername, String customerPassword) {
        this.companyName = companyName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

  
    }

    