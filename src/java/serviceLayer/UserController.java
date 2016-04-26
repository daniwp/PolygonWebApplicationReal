package serviceLayer;

import dataAccessLayer.mapper.MapperFacade;
import exceptions.UserAlreadyExistsException;
import javax.servlet.http.HttpSession;
import serviceLayer.entity.Customer;
import serviceLayer.entity.User;

/**
 *
 * @author Daniel
 */
public class UserController {

    MapperFacade mapperFacade = new MapperFacade();

    //Daniel
    //Validates a user and returns true if user exists and false if not
    public boolean validateLogin(String customerUsername, String customerPassword, HttpSession curSession) {
        User user = mapperFacade.validateUser(customerUsername, customerPassword);

        //If the user exists in the DB, the loggedIn attribute is set in the current session
        if (user != null) {
            curSession.setAttribute("loggedIn", true);

            //If the usertype equals 1, the customer attribute with a Customer object is set in the current session
            if (user.getType() == 1) {
                Customer customer = mapperFacade.getCustomerByUserId(user.getUserId());
                curSession.setAttribute("customer", customer);

            //If the usertype equals 0, the admin attribute is set in the current session
            } else if (user.getType() == 0) {
                curSession.setAttribute("admin", true);
            }

            return true;
        
        //If there is no user with the given username and password, an error attribute is set in the current session
        } else {
            curSession.setAttribute("loginError", "An error occurred. Please try again.");
            return false;
        }
    }

    public void addUser(String username, String password, int type) throws UserAlreadyExistsException {
        User user = new User(username, password, type);
        mapperFacade.addUser(user);
    }

}
