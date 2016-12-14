//for one action ,update only.This servlet open below home page
import com.DBConnect;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class FundView1 extends HttpServlet { 
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
                out.print("<div style='border:1px solid black;width:1080px;height:600px;overflow-y: scroll;'>");;
                out.print("<table class='table table-bordered' id='viewtble1'>");
                out.print("<thead><th>Reciept No</th><th>Name</th><th>Amount</th><th>Amount Status</th><th>Date</th><th>cashier Name</th><th>Status</th><th>City</th><th>Action</th></thead><tbody>");

                Statement smt = con.createStatement();	
                ResultSet rs=smt.executeQuery("select * from insertdata order by reciptno DESC");
                while(rs.next())
                    {
                    
                        out.print("<tr><td>" + rs.getString(1)+"</td>");
                        //out.print("<td id='name'>"+ rs.getString(2)+"</td>");
                       // out.print("<td id='amount'>"+rs.getString(3)+"</td>");
                       // out.print("<td id='amountstatus'>"+rs.getString(4)+"</td>"); 
                       // out.print("<td id='date'>"+rs.getString(5)+"</td>"); 
                       // out.print("<td id='cashiername'>"+rs.getString(6)+"</td>");
                       // out.print("<td id='status'>"+rs.getString(7)+"</td>");
                       out.print("<td>"+ rs.getString(2)+"</td>");
                       out.print("<td>"+rs.getString(3)+"</td>");
                       out.print("<td >"+rs.getString(4)+"</td>"); 
                       out.print("<td>"+rs.getString(5)+"</td>"); 
                       out.print("<td>"+rs.getString(6)+"</td>");
                       out.print("<td>"+rs.getString(7)+"</td>");
                        out.print("<td>"+rs.getString(8)+"</td>");
                        /*out.print("&date="+ "<td colspan='2'id='updatebtnId'>"
                            + "<button class='updatebtnFund'><a href='update1?reciptno="+rs.getString(1)+ 
                            "&name="+rs.getString(2)+ "&amount=" +rs.getString(3)+ 
                            "&amntstatus=" +rs.getString(4) + "&date=" +rs.getString(5)+
                           "&cashiername=" +rs.getString(6)+ "&status=" +rs.getString(7)+"'>Update</a></button></td></tr>");*/
                        out.print("<td colspan='2'><button class='updatebtnFund' data-reciptno='"+rs.getString(1)+"' data-name='"+rs.getString(2)+""
                                + "' data-amount='"+rs.getString(3)+"' data-amountstatus='"+rs.getString(4)+"' data-date='"+rs.getString(5)+""
                                + "' data-casheirname='"+rs.getString(6)+"'data-status='"+rs.getString(7)+"' data-cityfund='"+rs.getString(8)+"' type='button'>Update</button></td></tr>");
                        //data-cityfund-cityfund is column name in database
                    }
                    // out.print("<tr><td colspan='8' align='center'><button class='btn btn-primary'><a href='WEB-INF/classes/PrintWindow.class'>Print</a><button></td></tr>");								
                out.print("</tbody></table></div>");
                //out.print("</div>");
 
              }
        catch (Exception e2)
            {
                e2.printStackTrace();
            }
    }
} 