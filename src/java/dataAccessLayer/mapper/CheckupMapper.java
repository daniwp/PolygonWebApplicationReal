package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Checkup;

/**
 *
 * @author danie
 */
public class CheckupMapper
{

    // Peter
    public void updateCheckupStatusById(int checkupId, String status)
    {

        try
        {
            String query = "UPDATE checkup SET status = ? Where checkupId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, checkupId);

            ps.executeUpdate();

        } catch (SQLException ee)
        {
            ee.printStackTrace();
        }

    }

    //Nicolai
    public void createNewCheckup(Checkup checkup)
    {

        try
        {

            String query = "INSERT INTO Checkup (checkupId, status, email, date, buildingId) VALUES (?,?,?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, checkup.getCheckupId());
            ps.setString(2, checkup.getStatus());
            ps.setString(3, checkup.getCustomerEmail());
            ps.setString(4, checkup.getDate());
            ps.setInt(5, checkup.getBuildingId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

    }

    //Daniel
    public List<Checkup> getAllCheckupsByBuildingId(int buildingId)
    {
        List<Checkup> checkups = new ArrayList();
        ResultSet rs = null;
        Checkup checkup = null;

        try
        {

            String query = "SELECT * FROM checkup WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            rs = ps.executeQuery();

            while (rs.next())
            {
                int checkupId = rs.getInt("checkupId");
                String status = rs.getString("status");
                String date = rs.getString("checkupDate");
                String email = rs.getString("email");

                checkup = new Checkup(checkupId, status, date, email, buildingId);
                checkups.add(checkup);
            }

            rs.close();
            ps.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return checkups;
    }

    //Lasse
    public void deleteCheckupById(int checkupId) {
        
        try {
            
            String query = "DELETE FROM checkup WHERE (checkupId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, checkupId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee)
        {
            ee.printStackTrace();
        }

    }

    //Daniel
    public Checkup getCheckupById(int checkupId)
    {
        ResultSet rs = null;
        Checkup checkup = null;

        try
        {

            String query = "SELECT * FROM checkup WHERE (checkupId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, checkupId);
            rs = ps.executeQuery();

            while (rs.next())
            {

                String status = rs.getString("status");
                String date = rs.getString("checkupDate");
                String email = rs.getString("email");
                int buildingId = rs.getInt("buildingId");

                checkup = new Checkup(checkupId, status, date, email, buildingId);

            }

            rs.close();
            ps.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return checkup;
    }
}
