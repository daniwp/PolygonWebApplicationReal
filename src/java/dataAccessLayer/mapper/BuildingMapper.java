package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviceLayer.entity.Building;

public class BuildingMapper {

    public void addBuilding(Building b)  {

        try {
            String query = "INSERT INTO building (buildingName, address, zipcode, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, customerId) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, b.getName());
            ps.setString(2, b.getAddress());
            ps.setInt(3, b.getZipcodes());
            ps.setString(4, b.getCity());
            ps.setInt(5, b.getBuildingYear());
            ps.setInt(6, b.getFloors());
            ps.setDouble(7, b.getTotalSize());
            ps.setString(8, b.getBuildingOwner());
            ps.setInt(9, b.getBuildingCondition());
            ps.setInt(10, b.getCustomerId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            
        }
    }
}
