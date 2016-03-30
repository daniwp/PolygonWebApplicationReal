package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Floor;
import static sun.audio.AudioPlayer.player;

public class FloorMapper {

    public boolean addFloors(List<Floor> floors) {
        try {
            String query = "INSERT INTO floor (floor, size, buildingId) VALUES (?, ?, ?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
        
            for(Floor floor : floors){
                ps.setInt(1, floor.getFloor());
                ps.setDouble(2, floor.getSize());
                ps.setInt(3, floor.getBuildingId());
                
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
