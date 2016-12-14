
import com.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cashier extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
               
		try{
                        Connection con=DBConnect.getConnection();
                        Statement stmt=con.createStatement();
			String sqlQuery2= "select name from insertd where designation = 'Cashier'";
                        ResultSet rs = stmt.executeQuery(sqlQuery2);
                        out.println("<select>");
                        out.print("<option value=''>Select any one</option>");
                        while(rs.next()){   
                           
                            out.print("<option value=' + rs.getString(0) +'>"+ rs.getString(1) + "</option>");
                           
                        }
                        out.println("</select>");
			}
                catch(SQLException e1)
                    {
		e1.printStackTrace();
                    }
                response.sendRedirect("Membership.jsp"); 
//RequestDispatcher rd=request.getRequestDispatcher("Membership.jsp");
//rd.include(request, response);
}
   
  }    
    
