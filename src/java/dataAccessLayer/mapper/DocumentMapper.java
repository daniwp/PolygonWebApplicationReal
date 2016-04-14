/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import serviceLayer.entity.Document;
import serviceLayer.entity.Report;

/**
 *
 * @author Nicolai
 */
public class DocumentMapper {
    
    public void saveDocument(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException{    
        
        try {
        
            String query = "INSERT INTO document(documentFile, documentFileName, documentUploadDate, buildingId) values (?, ?, ?, ?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
        
            ps.setBlob(1, input);
            ps.setString(2, name);
            ps.setString(3, date);
            ps.setInt(4, buildingId);
        
            ps.executeUpdate();
            
            ps.close();
        
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
    }
        
    public List<Document> getAllDocumentsByBuildingId(int buildingId) {
        List<Document> documents = new ArrayList();
        ResultSet rs = null;
        Document document = null;
        
        try{
            
            String query = "SELECT * FROM document WHERE (BuildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setInt(1, buildingId);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                
                int documentId = rs.getInt("documentId");
                String documentFileName = rs.getString("documentFileName");
                String documentDate = rs.getString("documentUploadDate");
                
                document = new Document(documentId, documentFileName, documentDate, buildingId);
                documents.add(document);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return documents;
    }   
    
    public OutputStream downloadDocument(ServletContext context, HttpServletResponse response, int documentId) throws ClassNotFoundException {
        ResultSet rs = null;
        OutputStream output = null;
        final int BUFFER_SIZE = 4096;

        try {

            String query = "SELECT * FROM document WHERE (documentId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, documentId);

            rs = ps.executeQuery();

            if (rs.next()) {

                String documentName = rs.getString("documentFileName");
                Blob blob = rs.getBlob("documentFile");

                InputStream inputStream = blob.getBinaryStream();

                String mimeType = context.getMimeType(documentName);
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                response.setContentType(mimeType);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; documentName=\"%s\"", documentName);
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
