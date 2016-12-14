//Search with column for view Fund.
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

public class SearchFund extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String optionvalue = request.getParameter("optionvalue");
        String textvalue = request.getParameter("textvalue");
        out.print(optionvalue);
        
       
        try  {
                Connection con=DBConnect.getConnection();
                Statement smt = con.createStatement();
                ResultSet rs=smt.executeQuery("select * from insertdata where "+optionvalue+"='"+textvalue+"'"); 
                out.print("<table class='table table-bordered' id='ShowTablefund'>");
                out.print("<thead><th>Member ID</th><th>Member Name</th><th>Registration Year/Date</th>"
                        + "<th>Registration Amount Status</th><th>Status</th><th>Designation</th><th>Status</th></thead><tbody id='show_append'>");
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
                        out.print("<td>"+rs.getString(7)+"</td>");
                }
                out.print("</table>");                                       
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

}