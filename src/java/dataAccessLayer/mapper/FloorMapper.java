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

    public boolean addFloors(List<Floor> floors) {
        try {
            String query = "INSERT INTO floor (floor, size, buildingId) VALUES (?, ?, ?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            for (Floor floor : floors) {
                ps.setInt(1, floor.getFloor());
                ps.setDouble(2, floor.getSize());
                ps.setInt(3, floor.getBuildingId());

                ps.executeUpdate();
            }
            
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
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
            
            String query = "SELECT * FROM floor WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            while(rs.next()) {
                
                int floorId = rs.getInt("floorId");
                int floorNr = rs.getInt("floor");
                double floorSize = rs.getDouble("size");
                int buildingID = rs.getInt("buildingId");
                
                floor = new Floor(floorId, floorNr, floorSize, buildingId);
                floors.add(floor);
                
                ps.executeQuery();
            }
            
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return floors;
    }
}
