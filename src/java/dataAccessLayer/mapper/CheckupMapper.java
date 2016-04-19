
package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Checkup;

/**
 *
 * @author danie
 */
public class CheckupMapper {
    
    // Peter
    public void updateCheckupStatusById(int checupId, String status) {
        
    }
    
    //Nicolai
    public void createNewCheckup(Checkup checkup) {
        
    }
    
    //Daniel
    public List<Checkup> getAllCheckupsByBuildingId(int buildingId) {
        
    }
    
    //Lass
    public void deleteCheckupById(int checkupId) {
        try {
            String query = "DELETE FROM building WHERE (checkupId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, checkupId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }
    
    //Daniel
    public Checkup getCheckupById(int checupId) {
        
    }
}
