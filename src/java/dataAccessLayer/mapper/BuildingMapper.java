package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Building;

public class BuildingMapper {
    //made by Lasse
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
    
    // In this method we get all the information about the building up from the database.
    
    public List<Building> getAllBuildings(int customerId) {
        List<Building> buildings = new ArrayList();
        Building building;
        ResultSet rs = null;
        try {

            String query = "Select * from building WHERE customerId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            ps.executeQuery();

            while (rs.next()) {

                int buildingId = rs.getInt("buildingId");
                String buildingName = rs.getString("buildingName");
                String buildingAddress = rs.getString("address");
                int buildingZip = rs.getInt("zipcode");
                String buildingCity = rs.getString("city");
                int buildingYear = rs.getInt("buildingYear");
                int buildingFloor = rs.getInt("floors");
                double buildingSize = rs.getDouble("totalSize");
                String buildingOwner = rs.getString("buildingOwner");
                int buildingCondition = rs.getInt("buildingCondition");
                int buildingcustomerId = rs.getInt("customerId");
                
                building = new Building(buildingId, buildingName, buildingAddress, buildingZip, buildingCity, buildingYear,buildingFloor, buildingSize, buildingOwner, buildingCondition, buildingcustomerId);
                
                buildings.add(building);
            }

        } catch (Exception e) {
        }
        return buildings;
    }


    //made by Lasse
    public void deleteBuildingByBuildingId(int buildingId){
        try {
            String query = "DELETE * FROM building WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            
        }
    }
}
