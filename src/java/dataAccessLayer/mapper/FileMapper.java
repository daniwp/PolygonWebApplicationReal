package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import serviceLayer.entity.Report;

/**
 *
 * @author danie
 */
public class FileMapper {

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
        ResultSet rs = null;
        Report report = null;
        
        try {

            String query = "SELECT * FROM report WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setInt(1, buildingId);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int reportId = rs.getInt("reportId");
                String fileName = rs.getString("reportFileName");
                String date = rs.getString("reportUploadDate");
                
                report = new Report(reportId, fileName, date, buildingId);
                reports.add(report);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return reports;
    }

    public OutputStream downloadReport(ServletContext context, HttpServletResponse response, int reportId) throws ClassNotFoundException {
        ResultSet rs = null;
        OutputStream output = null;
        final int BUFFER_SIZE = 4096;

        try {

            String query = "SELECT * FROM report WHERE (reportId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, reportId);

            rs = ps.executeQuery();

            if (rs.next()) {

                String fileName = rs.getString("reportFileName");
                Blob blob = rs.getBlob("reportFile");

                InputStream inputStream = blob.getBinaryStream();

                String mimeType = context.getMimeType(fileName);
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                response.setContentType(mimeType);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                response.setHeader(headerKey, headerValue);

                OutputStream outputStream = response.getOutputStream();

                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outputStream.close();
                System.out.println("File saved");
            }

            ps.close();
            rs.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        return output;
    }

}
