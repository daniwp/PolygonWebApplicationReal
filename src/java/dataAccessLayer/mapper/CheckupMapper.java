package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Checkup;

/**
 *
 * @author danie
 */
public class CheckupMapper {
    
    // Here we get information about all pending checkups
    public List<Checkup> getAllPendingCheckups() {
        List<Checkup> pendingCheckups = new ArrayList();

        try {
            String query = "SELECT checkupId, status, checkupDate, email, buildingId FROM checkup WHERE status = 'Pending...'";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                int checkupId = rs.getInt("checkupId");
                String status = rs.getString("status");
                String date = rs.getString("checkupDate");
                String email = rs.getString("email");
                int buildingId = rs.getInt("buildingId");
                
                Checkup checkup = new Checkup(checkupId, status, date, email, buildingId);
                pendingCheckups.add(checkup);
                
            }
            
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return pendingCheckups;
    }

    // Peter
    // Here we can update a checkup status
    public void updateCheckupStatusById(int checkupId, String status) {

        try {
            String query = "UPDATE checkup SET status = ? WHERE checkupId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, checkupId);

            ps.executeUpdate();

        } catch (SQLException ee) {
            ee.printStackTrace();
        }

    }

    //Nicolai
    // Here we create a checkup
    public void createNewCheckup(Checkup checkup) {

        try {

            String query = "INSERT INTO Checkup (status, email, checkupDate, buildingId) VALUES (?,?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, checkup.getStatus());
            ps.setString(2, checkup.getCustomerEmail());
            ps.setString(3, checkup.getDate());
            ps.setInt(4, checkup.getBuildingId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //Daniel
    // Here we get information about all checkups by building id
    public List<Checkup> getAllCheckupsByBuildingId(int buildingId) {
        List<Checkup> checkups = new ArrayList();

        try {
            String query = "SELECT checkupId, status, checkupDate, email FROM checkup WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int checkupId = rs.getInt("checkupId");
                String status = rs.getString("status");
                String date = rs.getString("checkupDate");
                String email = rs.getString("email");

                Checkup checkup = new Checkup(checkupId, status, date, email, buildingId);
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
    // Here we can delete a checkup
    public void deleteCheckupById(int checkupId) {

        try {
            String query = "DELETE FROM checkup WHERE (checkupId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, checkupId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }
    
    //Daniel
    //Here we can delete a checkup by a building id
    public void deleteCheckupsByBuildingId(int buildingId) {

        try {
            String query = "DELETE FROM checkup WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    //Daniel
    //Here we can get information about a checkup
    public Checkup getCheckupById(int checkupId) {
        Checkup checkup = null;

        try {

            String query = "SELECT status, checkupDate, email, buildingId FROM checkup WHERE (checkupId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, checkupId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String status = rs.getString("status");
                String date = rs.getString("checkupDate");
                String email = rs.getString("email");
                int buildingId = rs.getInt("buildingId");

                checkup = new Checkup(checkupId, status, date, email, buildingId);

            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return checkup;
    }
}
