//member name auto populated in membership form
import com.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewMemDropDown extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
      
                try
                    {
                        Connection con=DBConnect.getConnection();
                        Statement stmt=con.createStatement();
			String sqlQuery1 = "select id,name from insertd";
                        ResultSet rs=stmt.executeQuery(sqlQuery1); 
                        out.println("<select id='memberNames'>");
                        out.println("<option value=''>Select any one</option>");
                        while(rs.next())
                          {   
                              //int id = Integer.parseInt(rs.getInt(0)); 
                            out.println("<option value= "+ rs.getString(1) + ">" + rs.getString(2) + "</option>");
                          }
                        out.println("</select>");
                    }
                catch(SQLException e1)
                    {
		e1.printStackTrace();
                    }
/*RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/ViewDropD.jsp");
RequetsDispatcherObj.forward(request, response);*/
    } 
}    
    
