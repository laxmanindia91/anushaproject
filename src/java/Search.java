//Search with column for view member.
import com.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String t = request.getParameter("a");
        String t1 = request.getParameter("v1");
       out.print(t);
       
        try  {
                Connection con=DBConnect.getConnection();
                Statement smt = con.createStatement();
                ResultSet rs=smt.executeQuery("select * from insertd where "+t+"='"+t1+"'"); 
                out.print("<table class='table table-bordered' id='ShowTable'>");
                out.print("<thead><th>Member ID</th><th>Member Name</th><th>Registration Year/Date</th>"
                        + "<th>Registration Amount Status</th><th>Status</th><th>Designation</th></thead><tbody id='show_append'>");
                while(rs.next())
                {
                        //out.print("<td>"+rs.getString(1)+"</td>");
                        out.print("<tr>");
                        out.print("<td>"+rs.getString(1)+"</td>");
                        out.print("<td>"+rs.getString(2)+"</td>");
                        out.print("<td>"+rs.getString(3)+"</td>");
                        out.print("<td>"+rs.getString(4)+"</td>"); 
                        out.print("<td>"+rs.getString(5)+"</td>"); 
                        out.print("<td>"+rs.getString(6)+"</td>");
                }
                out.print("</table>");                                       
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

}