/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import java.util.List;
import serviceLayer.entity.Checkup;

/**
 *
 * @author Daniel
 */
public class CheckupController {
    
    MapperFacade mapperFacade = new MapperFacade();
    
    public void updateCheckupsStatusById(int checkupId, String status) {
        mapperFacade.updateCheckupStatusById(checkupId, status);
    }
    
    public void createNewCheckup(String status, String date, String email, int buildingId) {
        Checkup checkup = new Checkup(status, date, email, buildingId);
        mapperFacade.createNewCheckup(checkup);
    }
    
    public List<Checkup> getAllCheckupsByBuildingId(int buildingId) {
        return mapperFacade.getAllCheckupsByBuildingId(buildingId);
    }
    
    public void deleteCheckupById(int checkupId) {
        mapperFacade.deleteCheckupById(checkupId);
    }
    
    public Checkup getCheckupById(int CheckupId) {
        return mapperFacade.getCheckupById(CheckupId);
    }
}
