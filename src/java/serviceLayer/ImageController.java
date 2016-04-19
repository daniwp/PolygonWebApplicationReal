/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import java.io.InputStream;
import java.util.List;
import serviceLayer.entity.Image;

/**
 *
 * @author Daniel
 */
public class ImageController {
    
    MapperFacade mapperFacade = new MapperFacade();
    
    public void saveImage(InputStream inputStream, String name, int buildingId) throws ClassNotFoundException {
        mapperFacade.saveImage(inputStream, name, buildingId);
    }

    public List<Image> getAllImagesByBuildingId(int buildingId) {
        return mapperFacade.getAllImagesByBuildingId(buildingId);
    }

    public InputStream downloadImage(int imageId) throws ClassNotFoundException {
        return mapperFacade.downloadImage(imageId);
    }

    public void deleteImageByImageId(int imageId) {
        mapperFacade.deleteImageByImageId(imageId);
    }

    public String getImageNameById(int imageId) {
        return mapperFacade.getImageNameById(imageId);
    }
}
