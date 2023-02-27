
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ravne
 */
public class ShoppingListServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        
        if(logout!=null) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request,response);
            return;
        }
        
        
       getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
               .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        ArrayList<String> list;
        
        if(action.equals("register")){
        list=new ArrayList<>();
        session.setAttribute("list",list);
        String username = request.getParameter("username");
        request.setAttribute( "username",username);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
               .forward(request, response);
        }
        else if(action.equals("add")){
            String itemToAdd = request.getParameter("itemToAdd");
            list = (ArrayList<String>) session.getAttribute("list");
            list.add(itemToAdd);
            session.setAttribute("list",list);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
               .forward(request, response);
        }
        else if(action.equals("delete")) {
            String itemToDelete = request.getParameter("item");
            list = (ArrayList<String>) session.getAttribute("list");
            list.remove(itemToDelete);
            session.setAttribute("list",list);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request,response);
        }
    }
}
