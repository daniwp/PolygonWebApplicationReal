
package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Checkup;

/**
 *
 * @author danie
 */
public class CheckupMapper {
    
    // Peter
    public void updateCheckupStatusById(int checkupId, String status) {
        
        
        try {
            String query = "UPDATE checkup SET status = ? Where checkupId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setString(1, status);
            ps.setInt(2, checkupId);
            
            ps.executeUpdate();
            
        }catch (SQLException ee) {
            ee.printStackTrace();
        }
        
    }
    
    //Nicolai
    public void createNewCheckup(Checkup checkup) {
        
    }
    
    //Daniel
    public List<Checkup> getAllCheckupsByBuildingId(int buildingId) {
        
    }
    
    //Lass
    public void deleteCheckupById(int checkupId) {
        
    }
    
    //Daniel
    public Checkup getCheckupById(int checupId) {
        
    }
}
