//update fund 
import com.DBConnect;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update1 extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String na = request.getParameter("fname");
        //out.print(na);
        String pa = request.getParameter("amnt");
        String r = request.getParameter("amntStatus");
        String q = request.getParameter("date1");
        String e = request.getParameter("cashName");
        String f = request.getParameter("optradio");
        String idFund = request.getParameter("updaterecipt");//hiddenfield id in addFund.jsp
               try
                 {
                    Connection con=DBConnect.getConnection();
                    Statement smt= con.createStatement();
                   //String sqlQuery = "update insertd SET name =' " +n+"' , date =  ' " +p+"', amntstatus = ' " +r+"', status = ' " +q+"' , designation = ' " +e+"' where id = ' " +id1+ "' ";
                    String query = "UPDATE insertdata SET name=?, amount=?, amountstatus=?, date=?, cashiername=?, status=? WHERE reciptno='" +idFund+ "'";
                    PreparedStatement ps= con.prepareStatement(query);
                    ps.setString(1,na);
                    ps.setString(2,pa);
                    ps.setString(3,r);
                    ps.setString(4,q);
                    ps.setString(5,e);
                    ps.setString(6,f);
                    ResultSet rs=smt.executeQuery("select * from insertdata where reciptno='" +idFund+ "'");     
                        while(rs.next())
                         {
                            out.print("<tr><td>"+rs.getString(1)+"</td>");
                            out.print("<td id='name"+rs.getString(1)+"'>"+rs.getString(2)+"</td>");
                            out.print("<td id='amount"+rs.getString(1)+"'>"+rs.getString(3)+"</td>");
                            out.print("<td id='amountstatus"+rs.getString(1)+"'>"+rs.getString(4)+"</td>");
                            out.print("<td id='date"+rs.getString(1)+"'>"+rs.getString(5)+"</td>");
                            out.print("<td id='casheirname"+rs.getString(1)+"'>"+rs.getString(6)+"</td>"); 
                            out.print("<td id='status"+rs.getString(1)+"'>"+rs.getString(7)+"</td>");
                            
                            out.print("<td colspan='2'><button class='updatebtnFund' data-reciptno='"+rs.getString(1)+"'"
                                    + " data-name='"+rs.getString(2)+"' data-amount='"+rs.getString(3)+""
                                    + "' data-amountstatus='"+rs.getString(4)+"' data-date='"+rs.getString(5)+""
                                    + "' data-casheirname='"+rs.getString(6)+"'data-status='"+rs.getString(7)+""
                                    + "' type='button'>Update</button></td>");
                           
                        }
                    ps.execute();
                }
              catch(Exception e1)
                {
                    System.out.println(e1);
                }
               //response.sendRedirect("belowFundTbl");
//RequestDispatcher rd=request.getRequestDispatcher("OMS.html");
//rd.forward(request, response);
    }
}