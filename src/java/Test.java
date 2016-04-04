
import dataAccessLayer.mapper.BuildingMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Building;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nicolai
 */
public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BuildingMapper buildingMapper = new BuildingMapper();
        List<Building> buildings = new ArrayList();
        
        buildings = buildingMapper.getAllBuildings(1);
        
        for (Building building : buildings) {
            System.out.println(building.getName());
        }
    }
}
