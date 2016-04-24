/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import serviceLayer.entity.Document;

/**
 *
 * @author Nicolai
 */
public class DocumentMapper {

    // Here we can save a document
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

    // Here we can get all documents related to a building
    public List<Document> getAllDocumentsByBuildingId(int buildingId) {
        List<Document> documents = new ArrayList();

        try {

            String query = "SELECT documentId, documentFileName, documentUploadDate"
                    + " FROM document WHERE (BuildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int documentId = rs.getInt("documentId");
                String documentFileName = rs.getString("documentFileName");
                String documentDate = rs.getString("documentUploadDate");

                Document document = new Document(documentId, documentFileName, documentDate, buildingId);
                documents.add(document);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return documents;
    }

    // Here we can download a document
    public InputStream downloadDocument(int documentId) {
        InputStream inputStream = null;

        try {

            String query = "SELECT documentFile FROM document WHERE (documentId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, documentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                Blob blob = rs.getBlob("documentFile");
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

    // Here we can get a document name by document id
    public String getDocumentNameById(int documentId) {
        String documentName = null;

        try {

            String query = "SELECT documentFileName FROM document WHERE (documentId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, documentId);
            ResultSet rs = ps.executeQuery();

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

    // Here we can delete a document
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
    
    // Here we can delete all documents related to a building
    public void deleteDocumentsByBuildingId(int buildingId) {

        try {
            
            String query = "DELETE FROM document WHERE (buildingId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, buildingId);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
