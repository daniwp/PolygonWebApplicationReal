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
    private String customerUserName;
    private String customerPassWord;

    public Customer(int customerId, String customerFirstName, String customerLastName, String customerUserName, String customerPassWord) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerUserName = customerUserName;
        this.customerPassWord = customerPassWord;
    }

    public Customer(String customerFirstName, String customerLastName, String customerUserName, String customerPassWord) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerUserName = customerUserName;
        this.customerPassWord = customerPassWord;
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

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getCustomerPassWord() {
        return customerPassWord;
    }

    public void setCustomerPassWord(String customerPassWord) {
        this.customerPassWord = customerPassWord;
    }

}
