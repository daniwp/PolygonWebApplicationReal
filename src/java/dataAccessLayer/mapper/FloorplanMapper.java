package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import serviceLayer.entity.Document;
import serviceLayer.entity.Floorplan;

/**
 *
 * @author Daniel
 */
public class FloorplanMapper {

    public void uploadFloorplan(InputStream input, String name, int floorId) {

        try {

            String query = "INSERT INTO floorplan (floorplanName, floorplan, floorId) values (?, ?, ?)";
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
        ResultSet rs = null;
        InputStream inputStream = null;

        try {

            String query = "SELECT * FROM floorplan WHERE (floorplanId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorplanId);

            rs = ps.executeQuery();

            if (rs.next()) {

                Blob blob = rs.getBlob("floorplan");

                inputStream = blob.getBinaryStream();

                inputStream.close();
                System.out.println("File saved");

            }

            ps.close();
            rs.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        return inputStream;
    }

    public Floorplan getFloorplanByFloorId(int floorId) {
        ResultSet rs = null;
        Floorplan floorplan = null;

        try {

            String query = "SELECT * FROM floorplan WHERE (floorId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorId);
            rs = ps.executeQuery();

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

    public String getFloorplanNameById(int floorplanId) {
        ResultSet rs = null;
        String floorplanName = null;

        try {

            String query = "SELECT (floorplanName) FROM floorplan WHERE (floorplanId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorplanId);
            rs = ps.executeQuery();
            
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
