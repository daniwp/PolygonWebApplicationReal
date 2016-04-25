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

    public boolean validateLogin(String customerUsername, String customerPassword, HttpSession curSession) {
        User user = mapperFacade.validateUser(customerUsername, customerPassword);

        if (user != null) {
            user.setUserId(mapperFacade.getUserIdByUsername(customerUsername));
            Customer customer = mapperFacade.getCustomerByUserId(user.getUserId());

            curSession.setAttribute("loggedIn", true);
            if (user.getType() == 1) {
                curSession.setAttribute("customer", customer);
            } else if (user.getType() == 0) {
                curSession.setAttribute("admin", true);
            }
            return true;
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
