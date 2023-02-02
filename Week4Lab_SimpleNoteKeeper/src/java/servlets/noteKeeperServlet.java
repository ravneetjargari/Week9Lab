
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
public class noteKeeperServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader (new FileReader(new File(path)));
        request.setAttribute("title",br.readLine());
        request.setAttribute("contents",br.readLine());
          String edit = request.getParameter("edit");
        
        if (edit == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request,response);
        }
        else {
           getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request,response); 
        }            
        
        PrintWriter pw = new PrintWriter(new BufferedWriter( new FileWriter(path,false)));
    
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter( new FileWriter(path,false)));
        
        String title= request.getParameter("titleEdit");
        String contents = request.getParameter("contentsEdit");
        
        pw.println(title);
        pw.println(contents);
        
        request.setAttribute("title",title);
        request.setAttribute("contents",contents);
 
    getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
            .forward(request, response);
    }
}
