package dataAccessLayer.mapper;

import dataAccessLayer.DBConnector;
import exceptions.UserAlreadyExistsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import serviceLayer.entity.Customer;
import serviceLayer.entity.User;

public class UserMapper {

    // Author: Daniel & Nicolai
    public User validateUser(String username, String password) {
        ResultSet rs = null;
        User user = null;
        try {
            String query = "SELECT * FROM user WHERE username = ? and password = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {

                int userId = rs.getInt("userId");
                String uName = rs.getString("username");
                String pWord = rs.getString("password");
                int type = rs.getInt("type");

                user = new User(userId, uName, pWord, type);

            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    // Daniel
    // Returns null if a user with the username already exists
    public User checkIfUserExistsByUsername(String username) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            String query = "SELECT * FROM user WHERE username = ?";
            ps = DBConnector.getConnection().prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("username"));
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public void addUser(User user) throws UserAlreadyExistsException {

        try {

            if (checkIfUserExistsByUsername(user.getUsername()) != null) {
                throw new UserAlreadyExistsException("A user with that username already exists!");
            }

            String query = "INSERT INTO user (username, password, type) VALUES (?,?,?)";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getType());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }
    
    public int getUserIdByUsername(String username) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int userId = 0;
        
        try {
            String query = "SELECT userId FROM user WHERE username = ?";
            ps = DBConnector.getConnection().prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            while (rs.next()) {
                userId = rs.getInt("userId");
            }
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userId;
    }
    
    public void deleteUserByUserId(int userId) {
        try {
            String query = "DELETE FROM user WHERE (userId) = ?";
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);

            ps.setInt(1, userId);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }
    
}
