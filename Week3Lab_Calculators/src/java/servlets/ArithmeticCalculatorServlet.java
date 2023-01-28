
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ravne
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result","---");
       getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enternum1 = request.getParameter("enternum1");
        request.setAttribute("enternum1", enternum1);
        String enternum2 = request.getParameter("enternum2");
        request.setAttribute("enternum2", enternum2);
        
        int answer=0;
        try {
    int int1 = Integer.parseInt(enternum1);
    int int2 = Integer.parseInt(enternum2);
    switch(request.getParameter("submit")) {
            case "+": 
                answer = int1+int2;
                break;
            case "-":
                answer = int1-int2;
                break;
            case "*": 
                answer = int1*int2;
                break;
            case "/": 
                answer = int1/int2;
                break;
    }
    
} catch (NumberFormatException e) {
    request.setAttribute("result","invalid");getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    return;
}
        request.setAttribute("result",answer);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }


}
