package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviceLayer.entity.Report;

/**
 *
 * @author danie
 */
public class ReportMapper {

    public void saveReport(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {

        try {

            String query = "INSERT INTO report (reportFile, reportFileName, reportUploadDate, buildingId) values (?, ?, ?, ?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setBlob(1, input);
            ps.setString(2, name);
            ps.setString(3, date);
            ps.setInt(4, buildingId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Report> getAllReportsByBuildingId(int buildingId) {
        List<Report> reports = new ArrayList();

        try {

            String query = "SELECT (reportId, reportFileName, reportUploadName) FROM report WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int reportId = rs.getInt("reportId");
                String fileName = rs.getString("reportFileName");
                String date = rs.getString("reportUploadDate");

                Report report = new Report(reportId, fileName, date, buildingId);
                reports.add(report);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reports;
    }

    public InputStream downloadReport(int reportId) {
        InputStream inputStream = null;

        try {

            String query = "SELECT (reportFile) FROM report WHERE (reportId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, reportId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Blob blob = rs.getBlob("reportFile");
                inputStream = blob.getBinaryStream();
            }

            inputStream.close();
            ps.close();
            rs.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        return inputStream;
    }

    public void deleteReportByReportId(int reportId) {

        try {
            
            String query = "DELETE FROM report WHERE (reportId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, reportId);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getReportNameById(int reportId) {
        String reportName = null;

        try {

            String query = "SELECT (reportFileName) FROM report WHERE (reportId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, reportId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                reportName = rs.getString("reportFileName");
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reportName;
    }

}
