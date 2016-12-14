//update servlet for member
import com.DBConnect;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberUpdate2 extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
            response.setContentType("text/html");
            PrintWriter out= response.getWriter();
            String na = request.getParameter("name1");
            String pa = request.getParameter("date1");
            String r = request.getParameter("opt1");
            String q = request.getParameter("myoptions");
            String e = request.getParameter("opt");
             String f = request.getParameter("city");
            String id1 = request.getParameter("updateid");
            //out.print(id1);
           // out.print(id1);
            try
                {
                    Connection con=DBConnect.getConnection();
                    Statement smt= con.createStatement();
                    //String sqlQuery = "update insertd SET name =' " +n+"' , date =  ' " +p+"', amntstatus = ' " +r+"', status = ' " +q+"' , designation = ' " +e+"' where id = ' " +id1+ "' ";
                    String query = "UPDATE insertd SET name=?, date=?, amntstatus=?, status=?, designation=?, city=? WHERE id='" +id1+ "'";
                    PreparedStatement ps= con.prepareStatement(query);
                        ps.setString(1,na);
                        ps.setString(2,pa);
                        ps.setString(3,r);
                        ps.setString(4,q);
                        ps.setString(5,e);
                        ps.setString(6,f);
                    ResultSet rs=smt.executeQuery("select * from insertd where id='" +id1+ "'");    
                          while(rs.next())
                                 {
                                    out.print("<td >"+rs.getString(1)+"</td>");
                                    out.print("<td id='name"+rs.getString(1)+"'>"+rs.getString(2)+"</td>");
                                    out.print("<td id='year"+rs.getString(1)+"'>"+rs.getString(3)+"</td>");
                                    out.print("<td id='amount"+rs.getString(1)+"'>"+rs.getString(4)+"</td>"); 
                                    out.print("<td id='status"+rs.getString(1)+"'>"+rs.getString(5)+"</td>"); 
                                    out.print("<td id='designation"+rs.getString(1)+"'>"+rs.getString(6)+"</td>");
                                    out.print("<td id='city"+rs.getString(1)+"'>"+rs.getString(7)+"</td>");

                                    //out.print("<td colspan='2'><a href=''>Update</a><a href='xyz?id=' " +rs.getString("id")+ "'>Delete</a></td>");
                                    //out.print("<td colspan='2'><a href='addMem.html?id=" + rs.getString(1)+ "'>Update</a></td>");
                                    out.print("<td colspan='2'><button class='updatebtn' data-id='"+rs.getInt(1)+""
                                            + "' data-name='"+rs.getString(2)+"' data-year='"+rs.getString(3)+""
                                            + "'data-amount='"+rs.getString(4)+"'data-status='"+rs.getString(5)+""
                                            + "'data-designation='"+rs.getString(6)+"'data-city='"+rs.getString(7)+"' data-updateid='"+rs.getString(1)+"' type='button'>"
                                            + "Update</button></td>");
                                }
                    ps.execute();
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            //response.sendRedirect("addMem.jsp");
        //RequestDispatcher rd=request.getRequestDispatcher("OMS.html");
        //rd.forward(request, response);
    }
}