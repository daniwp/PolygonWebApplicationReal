package EntityMapper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Costumer {
    private int customerId;
    private String customerName;

    public Costumer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Costumer(String customerName) {
        this.customerName = customerName;
    }

    public Costumer() {
    }
    
    

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    
    
}
