
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author ravne
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        
        User user = (User) session.getAttribute("user");
        
        if(logout != null){
            session.invalidate();
            request.setAttribute("msg","You have successfully logged out");
            
            getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp")
                    .forward(request, response);
            return;
        }
        if(user !=null){
            response.sendRedirect("home");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password= request.getParameter("password");
        
        if(username==null ||password==null){
            return;
        }
        AccountService accSer = new AccountService();
        User user = accSer.login(username,password);
        if(user != null) {
            session.setAttribute("user", user);
        }
        else {
            request.setAttribute("message","Invalid username and password");
            
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            
            getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp")
                .forward(request,response);
            
            return;
        }
        response.sendRedirect("home");
    }

}
