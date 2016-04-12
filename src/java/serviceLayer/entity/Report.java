/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.entity;

import java.io.File;

/**
 *
 * @author PeterHenriksen
 */
public class Report {
    
    private int reportId;
    private File mediumblob;

    public Report(int reportId, File mediumblob) {
        this.reportId = reportId;
        this.mediumblob = mediumblob;
    }

    public Report(File mediumblob) {
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

    public File getMediumblob() {
        return mediumblob;
    }

    public void setMediumblob(File mediumblob) {
        this.mediumblob = mediumblob;
    }
    
    

 
    
}
