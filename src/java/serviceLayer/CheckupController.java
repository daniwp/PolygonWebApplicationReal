/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Building;
import serviceLayer.entity.Checkup;
import serviceLayer.entity.Customer;
import serviceLayer.entity.PendingCheckup;

/**
 *
 * @author Daniel
 */
public class CheckupController {
    
    MapperFacade mapperFacade = new MapperFacade();
    
    // Returns a list of all checkups with the pending status in a wrapper object PendingCheckup
    public List<PendingCheckup> getAllPendingCheckups() {
        List<PendingCheckup> pendingCheckups = new ArrayList();
        
        List<Checkup> checkups = mapperFacade.getAllPendingCheckups();
        
        for (Checkup checkup : checkups) {
            
             int buildingId = checkup.getBuildingId();
             Building building = mapperFacade.getBuildingByBuildingId(buildingId);
             String buildingName = building.getName();
             Customer customer = mapperFacade.getCustomerByCustomerId(building.getCustomerId());
             String companyName = customer.getCompanyName();
             
             PendingCheckup pendingCheckup = new PendingCheckup(checkup, companyName, buildingName, buildingId);
             pendingCheckups.add(pendingCheckup);
             
        }
        
        return pendingCheckups;
    }
    
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
