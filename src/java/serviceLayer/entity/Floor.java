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
public class Floor {
    
    private int floorId;
    private int floor;
    private double size;
    private  int buildingId;

    public Floor(int floorId, int floor, double size, int buildingId) {
        this.floorId = floorId;
        this.floor = floor;
        this.size = size;
        this.buildingId = buildingId;
    }

    public Floor(int floor, double size, int buildingId) {
        this.floor = floor;
        this.size = size;
        this.buildingId = buildingId;
    }

    public Floor() {
    }
    
    public int getFloorId() {
        return floorId;
    }

    public int getFloor() {
        return floor;
    }

    public double getSize() {
        return size;
    }

    public int getBuildingId() {
        return buildingId;
    }
}
