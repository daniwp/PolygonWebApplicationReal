package serviceLayer.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Peter Henriksen
 */
public class Building {

    private int buildingId;
    private String name;
    private String address;
    private int zipcodes;
    private String city;
    private int buildingYear;
    private int floors;
    private double totalSize;
    private String buildingOwner;
    private int buildingCondition;
    private int customerId;

    public Building(int buildingId, String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) {
        this.buildingId = buildingId;
        this.name = name;
        this.address = address;
        this.zipcodes = zipcodes;
        this.city = city;
        this.buildingYear = buildingYear;
        this.floors = floors;
        this.totalSize = totalSize;
        this.buildingOwner = buildingOwner;
        this.buildingCondition = buildingCondition;
        this.customerId = costumerId;
    }

    public Building(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) {
        this.name = name;
        this.address = address;
        this.zipcodes = zipcodes;
        this.city = city;
        this.buildingYear = buildingYear;
        this.floors = floors;
        this.totalSize = totalSize;
        this.buildingOwner = buildingOwner;
        this.buildingCondition = buildingCondition;
        this.customerId = costumerId;
    }

    public Building(int buildingId, String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition) {
        this.buildingId = buildingId;
        this.name = name;
        this.address = address;
        this.zipcodes = zipcodes;
        this.city = city;
        this.buildingYear = buildingYear;
        this.floors = floors;
        this.totalSize = totalSize;
        this.buildingOwner = buildingOwner;
        this.buildingCondition = buildingCondition;
    }


    
    public Building() {
    }

    public int getBuildingId() {
        return buildingId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getZipcodes() {
        return zipcodes;
    }

    public String getCity() {
        return city;
    }

    public int getBuildingYear() {
        return buildingYear;
    }

    public int getFloors() {
        return floors;
    }

    public double getTotalSize() {
        return totalSize;
    }

    public String getBuildingOwner() {
        return buildingOwner;
    }

    public int getBuildingCondition() {
        return buildingCondition;
    }

    public int getCustomerId() {
        return customerId;
    }
}
