
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
        FloorMapper nicolai = new FloorMapper();
        Floor a = new Floor(4, 200.2, 1);
        Floor c = new Floor(5, 200.2, 1);
        List<Floor> floors = new ArrayList();
        floors.add(a);
        floors.add(c);
        nicolai.addFloors(floors);
    }
}
