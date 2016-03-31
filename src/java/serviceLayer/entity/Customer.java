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
    private String customerFirstName;
    private String customerLastName;
    private String userName;
    private String passWord;

    public Customer(int customerId, String customerFirstName, String customerLastName, String userName, String passWord) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Customer(String customerFirstName, String customerLastName, String userName, String passWord) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
    
}