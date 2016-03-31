
import dataAccessLayer.mapper.BuildingMapper;
import java.sql.SQLException;
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
        Building building = new Building("daj", "jsah", 1231, "jsada", 1990, 4, 20, "jkasdhk", 1, 1);
        buildingMapper.addBuilding(building);
        
    }
}
