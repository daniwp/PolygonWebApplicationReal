/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.entity;

/**
 *
 * @author Daniel
 */
public class Floorplan {
    private int floorplanId;
    private String floorplanName;
    private int floorId;

    public Floorplan(int floorplanId, String floorplanName, int floorId) {
        this.floorplanId = floorplanId;
        this.floorplanName = floorplanName;
        this.floorId = floorId;
    }

    public Floorplan(String floorplanName, int floorId) {
        this.floorplanName = floorplanName;
        this.floorId = floorId;
    }

    public int getFloorplanId() {
        return floorplanId;
    }

    public void setFloorplanId(int floorplanId) {
        this.floorplanId = floorplanId;
    }

    public String getFloorplanName() {
        return floorplanName;
    }

    public void setFloorplanName(String floorplanName) {
        this.floorplanName = floorplanName;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }
    
    
}
