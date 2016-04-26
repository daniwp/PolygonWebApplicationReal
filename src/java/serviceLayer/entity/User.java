
package serviceLayer.entity;

/**
 *
 * @author danie
 */
public class User {
    
    private int userId;
    private String username, password;
    private int type;

    public User(int userId, String username, String password, int type) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String username, String password, int type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }
    
    public User(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
