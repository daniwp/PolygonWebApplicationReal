/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.entity;

import java.sql.Blob;

/**
 *
 * @author PeterHenriksen
 */
public class Report {
    
    private int reportId;
    private Blob mediumblob;

    public Report(int reportId, Blob mediumblob) {
        this.reportId = reportId;
        this.mediumblob = mediumblob;
    }

    public Report(Blob mediumblob) {
        this.mediumblob = mediumblob;
    }

    public Report() {
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public Blob getMediumblob() {
        return mediumblob;
    }

    public void setMediumblob(Blob mediumblob) {
        this.mediumblob = mediumblob;
    }
    
    

}