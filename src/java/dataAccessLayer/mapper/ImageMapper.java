package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Image;

/**
 *
 * @author PeterHenriksen & NicolaiMikkelsen
 */
public class ImageMapper {

    public void saveImage(InputStream input, String name, int buildingId) throws ClassNotFoundException {

        try {

            String query = "INSERT INTO image (imageFile, imageName, buildingId) values (?,?,?)";
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

        try {
            String query = "SELECT imageId, imageName FROM image WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int imageId = rs.getInt("imageId");
                String imageName = rs.getString("imageName");

                Image image = new Image(imageId, imageName, buildingId);
                images.add(image);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return images;
    }

    public InputStream downloadImage(int imageId) throws ClassNotFoundException {
        InputStream inputStream = null;

        try {

            String query = "SELECT imageFile FROM image WHERE (imageId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, imageId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Blob blob = rs.getBlob("imageFile");
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

    public void deleteImageByImageId(int imageId) {

        try {
            String query = "DELETE FROM image WHERE (imageId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, imageId);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteImagesByBuildingId(int buildingId) {

        try {
            String query = "DELETE FROM image WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getImageNameById(int imageId) {
        String imageName = null;

        try {

            String query = "SELECT imageName FROM image WHERE (imageId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, imageId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
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
