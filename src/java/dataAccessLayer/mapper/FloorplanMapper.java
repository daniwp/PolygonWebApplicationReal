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
    
    public OutputStream downloadFloorplan(ServletContext context, HttpServletResponse response, int floorplanId) throws ClassNotFoundException {
        ResultSet rs = null;
        OutputStream output = null;
        final int BUFFER_SIZE = 4096;

        try {

            String query = "SELECT * FROM floorplan WHERE (floorplanId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorplanId);

            rs = ps.executeQuery();

            if (rs.next()) {

                String floorplanName = rs.getString("floorplanName");
                Blob blob = rs.getBlob("floorplan");

                InputStream inputStream = blob.getBinaryStream();

                String mimeType = context.getMimeType(floorplanName);
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                response.setContentType(mimeType);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; documentName=\"%s\"", floorplanName);
                response.setHeader(headerKey, headerValue);

                OutputStream outputStream = response.getOutputStream();

                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outputStream.close();
                System.out.println("File saved");
            }

            ps.close();
            rs.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        return output;
    }
    
    public Floorplan getFloorplanByFloorId(int floorId) {
        ResultSet rs = null;
        Floorplan floorplan = null;
        
        try{
            
            String query = "SELECT * FROM floorplan WHERE (floorId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setInt(1, floorId);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                
                int floorplanId = rs.getInt("floorplanId");
                String floorplanName = rs.getString("floorplanName");
                
                floorplan = new Floorplan(floorplanId, floorplanName, floorId);
                
            }
            
        } catch (SQLException ex){
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

}
