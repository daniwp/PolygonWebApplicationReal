package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.entity.Building;
import serviceLayer.entity.Checkup;
import serviceLayer.entity.Document;
import serviceLayer.entity.Floor;
import serviceLayer.entity.Image;
import serviceLayer.entity.Report;

/**
 *
 * @author Daniel
 */
public class BuildingController {

    FloorController floorController = new FloorController();
    CheckupController checkupController = new CheckupController();
    ReportController reportController = new ReportController();
    ImageController imageController = new ImageController();
    DocumentController documentController = new DocumentController();
    
    MapperFacade mapperFacade = new MapperFacade();

    // Creates a building and then inserts it into the database
    public void addBuilding(String name, String address, int zipcodes, String city, int buildingYear, int floors, double totalSize, String buildingOwner, int buildingCondition, int costumerId) throws SQLException, ClassNotFoundException {
        Building building = new Building(name, address, zipcodes, city, buildingYear, floors, totalSize, buildingOwner, buildingCondition, costumerId);

        mapperFacade.addBuilding(building);
    }
    
    //Daniel
    public void deleteBuildingByBuildingId(int buildingId) {
        
        for (Document document : documentController.getAlDocumentsByBuildingId(buildingId)) {
            documentController.deleteDocumentByDocumentId(document.getDocumentId());
        }
        
        for (Image image : imageController.getAllImagesByBuildingId(buildingId)) {
            imageController.deleteImageByImageId(image.getImageId());
        }
        
        for (Report report : reportController.getAllReportsByBuildingId(buildingId)) {
            reportController.deleteReportByReportId(report.getReportId());
        }
        
        for (Checkup checkup : checkupController.getAllCheckupsByBuildingId(buildingId)) {
            checkupController.deleteCheckupById(checkup.getCheckupId());
        }
        
        for (Floor floor : floorController.getAllFloorsByBuildingId(buildingId)) {
            floorController.deleteFloorByFloorId(floor.getFloorId());
        }
        
        mapperFacade.deleteBuildingByBuildingId(buildingId);
    }

    public int getBuildingIdByName(String name) {
        return mapperFacade.getBuildingIdByName(name);
    }

    public Building getBuildingByBuildingId(int buildingId) {
        Building building = new Building();
        building = mapperFacade.getBuildingByBuildingId(buildingId);
        return building;
    }

    public List<Building> getAllBuildingsByCustomerId(int CustomerId) {
        List<Building> buildings = mapperFacade.getAllBuildingsByCustomerId(CustomerId);
        return buildings;
    }

    public void updateBuildingFloorsByBuildingId(int buildingId) {
        mapperFacade.updateBuildingFloorsByBuildingId(buildingId);
    }

    public void editBuildingByBuildingId(Building building) throws SQLException {
        mapperFacade.editBuildingByBuildingId(building);
    }

}
