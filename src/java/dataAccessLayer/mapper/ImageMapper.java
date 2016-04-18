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
import serviceLayer.entity.Image;

/**
 *
 * @author PeterHenriksen & NicolaiMikkelsen
 */
public class ImageMapper {

    public void saveImage(InputStream input, String name, int buildingId) throws ClassNotFoundException {

        try {
            String query = "INSERT into image (imageFile, imageName, buildingId) values (?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setBlob(1, input);
            ps.setString(2, name);
            ps.setInt(3, buildingId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Image> getAllImagesByBuildingId(int buildingId) {
        List<Image> images = new ArrayList();
        ResultSet rs = null;
        Image image = null;

        try {
            String query = "Select * from image Where (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            rs = ps.executeQuery();

            while (rs.next()) {

                int imageId = rs.getInt("imageId");
                String imageName = rs.getString("imageName");

                image = new Image(imageId, imageName, buildingId);
                images.add(image);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return images;
    }

    public InputStream downloadImage(int imageId) throws ClassNotFoundException {
        ResultSet rs = null;
        InputStream inputStream = null;
        
        try {
            
            String query = "SELECT * FROM image WHERE (imageId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setInt(1, imageId);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                
                Blob blob = rs.getBlob("imageFile");
                        
                inputStream = blob.getBinaryStream();
                
                inputStream.close();
            }
            
            ps.close();
            rs.close();
        } catch (SQLException | IOException ex){
            ex.printStackTrace();
        }
        
        return inputStream;
    }
    
    
    public void deleteImageByImageId(int imageId){
        
        try{
            String query = "DELETE FROM image WHERE (imageId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setInt(1, imageId);
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public String getImageNameById (int imageId) {
        ResultSet rs = null;
        String imageName  = null;
        
        try {
            
            String query = "SELECT (imageName) FROM image WHERE (imageId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setInt(1, imageId);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                imageName = rs.getString("imageName");
            }
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return imageName;
    }
}