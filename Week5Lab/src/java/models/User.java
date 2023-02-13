
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
public class User {
    private String username;
    
    public User(String username){
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return "password";
    }
}
