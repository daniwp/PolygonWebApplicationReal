/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.entity;

/**
 *
 * @author PeterHenriksen
 */
public class Image {
    
    private int imageId;
    private String imageName;
    private int buildingId;

    public Image(int imageId, String imageName, int buildingId) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.buildingId = buildingId;
    }

    public Image(String imageName, int buildingId) {
        this.imageName = imageName;
        this.buildingId = buildingId;
    }

    public Image() {
    }

    public int getImageId() {
        return imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public int getBuildingId() {
        return buildingId;
    }
}
