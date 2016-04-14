/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author PeterHenriksen
 */
public class ImageMapper {
    
    public void saveImage(InputStream input, String name, int buildingId) throws ClassNotFoundException {
        
        try {
            String query = "INSERT into image (imageFile, imageName, buildingId) values (?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setBlob(1, input);
            ps.setString(2, name);
            ps.setInt(3, buildingId);
            
            ps.executeQuery();
            
            ps.close();
        }
            
         catch (SQLException ex) {
            ex.printStackTrace();
         }
    }
    
    
    public List<Image> getAllImagesByBuildingId(int buildingId){
        List<Image> images = new ArrayList();
        ResultSet rs = null;
        Image image = null;
        
        try {
            String query = "Select * from image Where (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setInt(1, buildingId);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                
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
    
    public OutputStream downloadImage(ServletContext context, HttpServletResponse response, int ImageId) throws ClassNotFoundException {
        ResultSet rs = null;
        OutputStream output = null;
        final int BUFFER_SIZE = 4096;

        try {

            String query = "SELECT * FROM image WHERE (imageId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, ImageId);

            rs = ps.executeQuery();

            if (rs.next()) {

                String imageName = rs.getString("imageName");
                Blob blob = rs.getBlob("imageFile");

                InputStream inputStream = blob.getBinaryStream();

                String mimeType = context.getMimeType(imageName);
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                response.setContentType(mimeType);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", imageName);
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
}
            
    
    
    
    
    
        
    
