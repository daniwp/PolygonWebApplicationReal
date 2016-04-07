
import dataAccessLayer.mapper.FloorMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Floor;

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
        FloorMapper fm = new FloorMapper();
        List<Floor> floors = new ArrayList();
        Floor floor = new Floor(1, 2, 6);
        floors.add(floor);
        fm.addFloors(floors);
    }
}
