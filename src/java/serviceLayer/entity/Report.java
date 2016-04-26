/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.entity;

/**
 *
 * @author PeterHenriksen
 */
public class Report {
    
    private int reportId;
    private String fileName;
    private String uploadDate;
    private int buildingId;

    public Report(int reportId, String fileName, String uploadDate, int buildingId) {
        this.reportId = reportId;
        this.fileName = fileName;
        this.uploadDate = uploadDate;
        this.buildingId = buildingId;
    }

    public Report(String fileName, String uploadDate, int buildingId) {
        this.fileName = fileName;
        this.uploadDate = uploadDate;
        this.buildingId = buildingId;
    }

    public Report() {
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public String getFileName() {
        return fileName;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public int getReportId() {
        return reportId;
    }
}