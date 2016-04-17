package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviceLayer.entity.Floor;

public class FloorMapper {
//Made by Nicolai

    public boolean checkIfFloorExists(int buildingId, int floorNumber) {
        ResultSet rs = null;
        
        try {
            
            String query = "SELECT * FROM floor WHERE (buildingId) = ? AND (floor) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setInt(1, buildingId);
            ps.setInt(2, floorNumber);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return true;
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    public void addFloor(Floor floor) {
        try {
            
            String query = "INSERT INTO floor (floor, size, buildingId) VALUES (?, ?, ?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floor.getFloor());
            ps.setDouble(2, floor.getSize());
            ps.setInt(3, floor.getBuildingId());
            
            ps.executeUpdate();

            ps.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Made by Nicolai
    public void deleteFloorsByBuildingId(int buildingId) {
        try {
            
            String query = "DELETE FROM floor WHERE buildingId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);

            ps.executeUpdate();

            ps.close();
            
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    public List<Floor> getAllFloorsByBuildingID(int buildingId) {
        List<Floor> floors = new ArrayList();
        Floor floor;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM floor WHERE buildingId = ? ORDER BY (floor)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            ps.setInt(1, buildingId);
            rs = ps.executeQuery();

            while (rs.next()) {

                int floorId = rs.getInt("floorId");
                int floorNr = rs.getInt("floor");
                double floorSize = rs.getDouble("size");
                int buildingID = rs.getInt("buildingId");

                floor = new Floor(floorId, floorNr, floorSize, buildingID);
                floors.add(floor);

            }

            ps.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return floors;
    }

    public void deleteFloorByFloorId(int floorId) {
        try {
            String query = "DELETE FROM floor WHERE floorId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floorId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }
}
