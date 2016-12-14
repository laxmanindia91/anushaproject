import com.DBConnect;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MemView1 extends HttpServlet {   
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();        
     try
         {
            Connection con=DBConnect.getConnection();
            out.print("<div class='container'>");
            out.print("<center><h1>View Records:</h1></center>");
            out.print("<div style='border:1px solid black;width:1080px;height:600px;overflow-y: scroll;'>");
             out.print("<div class='table-responsive'>");
            out.print("<table class='table table-bordered' id='able'>");
            out.print("<thead><th>Member ID</th><th>Member Name</th><th>Registration Year/Date</th>"
                    + "<th>Registration Amount Status</th><th>Status</th><th>Designation</th><th>City</th><th>Action</th></thead>"
                    + "<tbody id='show_append'>");

            Statement smt = con.createStatement();	
            ResultSet rs=smt.executeQuery("select * from insertd where isActive= 1 order by id DESC"); 
                while(rs.next())
                    {								
                        out.print("<tr>");
                        out.print("<td>"+rs.getString(1)+"</td>");
                        out.print("<td value='name'>"+rs.getString(2)+"</td>");
                        out.print("<td value='date'>"+rs.getString(3)+"</td>");
                        out.print("<td value='amount'>"+rs.getString(4)+"</td>"); 
                        out.print("<td value='status'>"+rs.getString(5)+"</td>"); 
                        out.print("<td value='designation'>"+rs.getString(6)+"</td>");
                        out.print("<td value='city'>"+rs.getString(7)+"</td>");
                        //out.print("<td colspan='2'><a href=''>Update</a><a href='xyz?id=' " +rs.getString("id")+ "'>Delete</a></td>");
                        out.print("<td colspan='2'><button class='updatebtn' data-id='"+rs.getString(1)+"' data-name='"+rs.getString(2)+""
                                + "' data-date='"+rs.getString(3)+"' data-amount='"+rs.getString(4)+"' data-status='"+rs.getString(5)+""
                                + "' data-designation='"+rs.getString(6)+"'data-city='"+rs.getString(7)+"'type='button'>Update</button></td>");
                        out.print("</tr>");
                }							
            out.print("</tbody></table></div>");
        }
     catch (Exception e2)
        {
            
        }
    }
} 