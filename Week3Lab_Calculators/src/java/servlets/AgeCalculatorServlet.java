
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AgeCalculatorServlet extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enterage = request.getParameter("enterage");
        request.setAttribute("enterage", enterage);
        boolean isNumber;
       

try {
    int Value = Integer.parseInt(enterage);
    isNumber=true;
    
    
} catch (NumberFormatException e) {
    isNumber=false;
}
        if(enterage==null||enterage.equals("")){
           
            request.setAttribute("message","You must give your current age.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);  
        }
        else if (isNumber==false){
        request.setAttribute("message","You must enter a number");
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
        }
        else{
            int age=Integer.parseInt(enterage);
            int x=1;
            int finalage= age+x;
            request.setAttribute("message","Your age next birthday will be" + " " + finalage);
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
        }
        
    }
}
