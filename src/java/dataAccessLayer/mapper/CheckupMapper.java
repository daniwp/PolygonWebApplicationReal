package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Checkup;

/**
 *
 * @author danie
 */
public class CheckupMapper {

    // Peter
    public void updateCheckupStatusById(int checkupId, String status) {

    }

    //Nicolai
    public void createNewCheckup(Checkup checkup) {

    }

    //Daniel
    public List<Checkup> getAllCheckupsByBuildingId(int buildingId) {
        List<Checkup> checkups = new ArrayList();
        ResultSet rs = null;
        Checkup checkup = null;

        try {

            String query = "SELECT * FROM checkup WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int checkupId = rs.getInt("checkupId");
                String status = rs.getString("status");
                String email = rs.getString("email");

                checkup = new Checkup(checkupId, status, email, buildingId);
                checkups.add(checkup);
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return checkups;
    }

    //Lasse
    public void deleteCheckupById(int checkupId) {

    }

    //Daniel
    public Checkup getCheckupById(int checkupId) {
        ResultSet rs = null;
        Checkup checkup = null;

        try {

            String query = "SELECT * FROM checkup WHERE (checkupId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, checkupId);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                String status = rs.getString("status");
                String email = rs.getString("email");
                int buildingId = rs.getInt("buildingId");

                checkup = new Checkup(checkupId, status, email, buildingId);
                
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return checkup;
    }
}
