import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

public class Logout extends HttpServlet {  
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException 
        {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter(); 
               
            HttpSession session=request.getSession(); 
            session.setAttribute("usrname", null); // in your logout.jsp page %>
            session.invalidate();
            //session.setAttribute("usrname",null);
            response.sendRedirect("index.jsp");
           // request.getRequestDispatcher("index.jsp").include(request, response);  
            //out.print("<center><h1> You are successfully logout!</h1></center>");  
        
        }  
}  
