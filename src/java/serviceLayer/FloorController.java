package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import exceptions.FloorAlreadyExistsException;
import java.util.List;
import serviceLayer.entity.Floor;

/**
 *
 * @author Daniel
 */
public class FloorController {
    
    MapperFacade mapperFacade = new MapperFacade();
    
    //Takes a list of floor objects and adds them to the database
    public void addFloor(int floorNumber, double size, int buildingId) throws FloorAlreadyExistsException {
        if (mapperFacade.checkIfFloorExists(buildingId, floorNumber)) {
            throw new FloorAlreadyExistsException("Some floors were not added, as one or more floors already exists");
        } else {
            Floor floor = new Floor(floorNumber, size, buildingId);
            mapperFacade.addFloor(floor);
        }
    }

    public void deleteFloorByFloorId(int floorId) {
        mapperFacade.deleteFloorplanByFloorId(floorId);
        mapperFacade.deleteFloorByFloorId(floorId);
    }
    
    public List<Floor> getAllFloorsByBuildingId(int buildingId) {
        List<Floor> floors = mapperFacade.getAllFloorsByBuildingID(buildingId);
        return floors;
    }
    
}
