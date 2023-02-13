
package models;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ravne
 */
public class AccountService {
    public User login(String username, String password){
        User user = new User(username);
        if(username.equals("abe") && password.equals(user.getPassword())){
            return user;
        }
        else if(username.equals("barb") && password.equals(user.getPassword())){
            return user;
        }
        return null;
    }
}