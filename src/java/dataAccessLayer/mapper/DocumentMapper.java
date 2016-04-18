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

    public void saveDocument(InputStream input, String name, String date, int buildingId) throws ClassNotFoundException {

        try {

            String query = "INSERT INTO document(documentFile, documentFileName, documentUploadDate, buildingId) values (?, ?, ?, ?)";
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

    public List<Document> getAllDocumentsByBuildingId(int buildingId) {
        List<Document> documents = new ArrayList();
        ResultSet rs = null;
        Document document = null;

        try {

            String query = "SELECT * FROM document WHERE (BuildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            rs = ps.executeQuery();

            while (rs.next()) {

                int documentId = rs.getInt("documentId");
                String documentFileName = rs.getString("documentFileName");
                String documentDate = rs.getString("documentUploadDate");

                document = new Document(documentId, documentFileName, documentDate, buildingId);
                documents.add(document);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return documents;
    }

    public InputStream downloadDocument(int documentId) {
        ResultSet rs = null;
        InputStream inputStream = null;
                
        try {

            String query = "SELECT * FROM document WHERE (documentId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, documentId);

            rs = ps.executeQuery();

            if (rs.next()) {

                Blob blob = rs.getBlob("documentFile");

                inputStream = blob.getBinaryStream();

                inputStream.close();
                System.out.println("File saved");
                
            }

            ps.close();
            rs.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        return inputStream;
    }
    
    public String getDocumentNameById(int documentId) {
        ResultSet rs = null;
        String documentName = null;
        
        try {

            String query = "SELECT (documentFileName) FROM document WHERE (documentId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, documentId);
            rs = ps.executeQuery();

            if (rs.next()) {
                documentName = rs.getString("documentFileName");
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return documentName;
    }
    
    public void deleteDocumentByDocumentId(int documentId) {

        try {
            String query = "DELETE FROM document WHERE (documentId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, documentId);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
