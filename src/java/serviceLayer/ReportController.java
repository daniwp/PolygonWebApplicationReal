/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import java.io.InputStream;
import java.util.List;
import serviceLayer.entity.Report;

/**
 *
 * @author Daniel
 */
public class ReportController {
    
    MapperFacade mapperFacade = new MapperFacade();
    
    public void saveReport(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {
        mapperFacade.saveReport(input, name, date, buildingId);
    }

    public List<Report> getAllReportsByBuildingId(int buildingId) {
        return mapperFacade.getAllReportsByBuildingId(buildingId);
    }

    public InputStream downloadReport(int reportId) throws ClassNotFoundException {
        return mapperFacade.downloadReport(reportId);
    }

    public void deleteReportByReportId(int reportId) {
        mapperFacade.deleteReportByReportId(reportId);
    }

    public String getReportNameById(int reportId) {
        return mapperFacade.getReportNameById(reportId);
    }
}
