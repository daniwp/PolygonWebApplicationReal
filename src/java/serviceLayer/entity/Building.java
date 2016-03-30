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
public class Building {
    
    private int buildingId;
    private String name;
    private String address;
    private int zipcodes;
    private String city;
    private int buildingYear;
    private int floors;
    private double totalSize;
    private String BuildingOwner;
    private int buildingCondition;
    private int customerId;

    public Building(int buildingId, String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String BuildingOwner, int buildingCondition, int costumerId) {
        this.buildingId = buildingId;
        this.name = name;
        this.address = address;
        this.zipcodes = zipcodes;
        this.city = city;
        this.buildingYear = buildingYear;
        this.floors = floors;
        this.totalSize = totalSize;
        this.BuildingOwner = BuildingOwner;
        this.buildingCondition = buildingCondition;
        this.customerId = costumerId;
    }

    public Building(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String BuildingOwner, int buildingCondition, int costumerId) {
        this.name = name;
        this.address = address;
        this.zipcodes = zipcodes;
        this.city = city;
        this.buildingYear = buildingYear;
        this.floors = floors;
        this.totalSize = totalSize;
        this.BuildingOwner = BuildingOwner;
        this.buildingCondition = buildingCondition;
        this.customerId = costumerId;
    }

    public Building() {
    }

    
    
    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcodes() {
        return zipcodes;
    }

    public void setZipcodes(int zipcodes) {
        this.zipcodes = zipcodes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBuildingYear() {
        return buildingYear;
    }

    public void setBuildingYear(int buildingYear) {
        this.buildingYear = buildingYear;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(double totalSize) {
        this.totalSize = totalSize;
    }

    public String getBuildingOwner() {
        return BuildingOwner;
    }

    public void setBuildingOwner(String BuildingOwner) {
        this.BuildingOwner = BuildingOwner;
    }

    public int getBuildingCondition() {
        return buildingCondition;
    }

    public void setBuildingCondition(int buildingCondition) {
        this.buildingCondition = buildingCondition;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    
}