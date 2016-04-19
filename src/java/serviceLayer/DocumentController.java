package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import java.io.InputStream;
import java.util.List;
import serviceLayer.entity.Document;

/**
 *
 * @author Daniel
 */
public class DocumentController {
    
    MapperFacade mapperFacade = new MapperFacade();
    
    public void saveDocument(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        mapperFacade.saveDocument(input, name, date, buildingId);
    }

    public List<Document> getAlDocumentsByBuildingId(int buildingId) {
        return mapperFacade.getAllDocumentsByBuildingId(buildingId);
    }

    public InputStream downloadDocument(int documentId) {
        return mapperFacade.downloadDocument(documentId);
    }

    public String getDocumentNameById(int documentId) {
        return mapperFacade.getDocumentNameById(documentId);
    }
    
    public void deleteDocumentByDocumentId(int documentId) {
        mapperFacade.deleteDocumentByDocumentId(documentId);
    }
    
}
