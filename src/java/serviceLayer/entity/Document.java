/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.entity;

/**
 *
 * @author Nicolai
 */
public class Document {
    private int documentId;
    private String documentFileName;
    private String documentUploadDate;
    private int buildingId;

    public Document(int documentId, String documentFileName, String documentUploadDate, int buildingId) {
        this.documentId = documentId;
        this.documentFileName = documentFileName;
        this.documentUploadDate = documentUploadDate;
        this.buildingId = buildingId;
    }

    public Document(String documentFileName, String documentUploadDate, int buildingId) {
        this.documentFileName = documentFileName;
        this.documentUploadDate = documentUploadDate;
        this.buildingId = buildingId;
    }

    public Document() {
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getDocumentFileName() {
        return documentFileName;
    }

    public void setDocumentFileName(String documentFileName) {
        this.documentFileName = documentFileName;
    }

    public String getDocumentUploadDate() {
        return documentUploadDate;
    }

    public void setDocumentUploadDate(String documentUploadDate) {
        this.documentUploadDate = documentUploadDate;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }
    
    
    
    
    
}
