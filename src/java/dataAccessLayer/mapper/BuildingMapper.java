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
    public void addBuilding(Building b) {

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
            ee.printStackTrace();
        }
    }

    // In this method we get all the information about the building up from the database.
    public List<Building> getAllBuildingsByCustomerId(int customerId) {
        List<Building> buildings = new ArrayList();
        Building building;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM building WHERE customerId = ? ORDER BY (buildingName)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            ps.setInt(1, customerId);
            rs = ps.executeQuery();

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

                building = new Building(buildingId, buildingName, buildingAddress, buildingZip, buildingCity, buildingYear, buildingFloor, buildingSize, buildingOwner, buildingCondition, buildingcustomerId);

                buildings.add(building);

            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buildings;
    }

    //made by Lasse
    public void deleteBuildingByBuildingId(int buildingId) {
        try {
            String query = "DELETE FROM building WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    // Daniel
    public void deleteBuildingByCustomerId(int customerId) {
        try {
            String query = "DELETE FROM building WHERE (customerId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, customerId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    // Daniel
    public List<Integer> getBuildingIdsByCustomerId(int customerId) {
        ResultSet rs = null;
        List<Integer> buildingIds = new ArrayList();

        try {
            String query = "Select buildingId from building WHERE customerId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            ps.setInt(1, customerId);

            rs = ps.executeQuery();

            while (rs.next()) {
                buildingIds.add(rs.getInt("buildingId"));
            }
            
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buildingIds;
    }

    // Daniel
    public Building getBuildingByBuildingId(int buildingId) {
        Building building = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM building WHERE buildingId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            rs = ps.executeQuery();

            while (rs.next()) {
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

                building = new Building(buildingName, buildingAddress, buildingZip, buildingCity, buildingYear, buildingFloor, buildingSize, buildingOwner, buildingCondition, buildingcustomerId);
            }

            ps.close();
            rs.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
        return building;
    }

    public int getBuildingIdByName(String name) {
        ResultSet rs = null;
        int buildingId = 0;
        try {
            String query = "Select buildingId from building WHERE buildingName = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {

                buildingId = rs.getInt("buildingId");

            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buildingId;
    }

    public int getNumberOfFloorsByBuildingId(int buildingId) {
        ResultSet rs = null;
        int numberOfFloors = 0;

        try {

            String query = "Select * from floor WHERE buildingId = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            rs = ps.executeQuery();

            while (rs.next()) {
                numberOfFloors++;
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return numberOfFloors;
    }

    public void updateBuildingFloorsByBuildingId(int buildingId) {

        try {
            int floors = getNumberOfFloorsByBuildingId(buildingId);

            String query = "UPDATE building SET floors=(?) where (buildingId) = (?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, floors);
            ps.setInt(2, buildingId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

}
