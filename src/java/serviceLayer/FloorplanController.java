/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import java.io.InputStream;
import serviceLayer.entity.Floorplan;

/**
 *
 * @author Daniel
 */
public class FloorplanController {
    MapperFacade mapperFacade = new MapperFacade();
    
    public void deleteFloorplanByFloorplanId(int floorplanId) {
        mapperFacade.deleteFloorplanByFloorplanId(floorplanId);
    }

    public Floorplan getFloorplanByFloorId(int floorId) {
        return mapperFacade.getFloorplanByFloorId(floorId);
    }

    public InputStream downloadFloorplan(int floorplanId) {
        return mapperFacade.downloadFloorplan(floorplanId);
    }

    public void uploadFloorplan(InputStream input, String name, int floorId) {
        mapperFacade.uploadFloorplan(input, name, floorId);
    }
    
    public String getFloorplanNameById(int floorplanId) {
        return mapperFacade.getFloorplanNameById(floorplanId);
    }
}
