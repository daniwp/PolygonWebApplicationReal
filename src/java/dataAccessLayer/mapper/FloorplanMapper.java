package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import serviceLayer.entity.Floorplan;

/**
 *
 * @author Daniel
 */
public class FloorplanMapper {

    public void uploadFloorplan(InputStream input, String name, int floorId) {

        try {

            String query = "INSERT INTO floorplan (floorplanName, floorplan, floorId) VALUES (?, ?, ?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, name);
            ps.setBlob(2, input);
            ps.setInt(3, floorId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public InputStream downloadFloorplan(int floorplanId) {
        InputStream inputStream = null;

        try {

            String query = "SELECT floorplan FROM floorplan WHERE (floorplanId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorplanId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Blob blob = rs.getBlob("floorplan");
                inputStream = blob.getBinaryStream();
            }

            inputStream.close();
            ps.close();
            rs.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        return inputStream;
    }

    public Floorplan getFloorplanByFloorId(int floorId) {
        Floorplan floorplan = null;

        try {

            String query = "SELECT floorplanId, floorplanName"
                    + " FROM floorplan WHERE (floorId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int floorplanId = rs.getInt("floorplanId");
                String floorplanName = rs.getString("floorplanName");

                floorplan = new Floorplan(floorplanId, floorplanName, floorId);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return floorplan;
    }

    public void deleteFloorplanByFloorplanId(int floorplanId) {

        try {
            
            String query = "DELETE FROM floorplan WHERE (floorplanId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorplanId);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteFloorplanByFloorId(int floorId) {

        try {
            
            String query = "DELETE FROM floorplan WHERE (floorId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorId);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getFloorplanNameById(int floorplanId) {
        String floorplanName = null;

        try {

            String query = "SELECT floorplanName FROM floorplan WHERE (floorplanId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorplanId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                floorplanName = rs.getString("floorplanName");
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return floorplanName;
    }

}
