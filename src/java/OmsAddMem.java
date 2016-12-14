import com.DBConnect;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class OmsAddMem extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
    response.setContentType("text/html");
    PrintWriter out= response.getWriter();
    String n = request.getParameter("name1");
    String p = request.getParameter("date1");
    String r = request.getParameter("opt1");
    String q = request.getParameter("myoptions");
    String e = request.getParameter("opt");
    String f = request.getParameter("city");
        try
            {
		Connection con=DBConnect.getConnection();
		String sqlQuery1 = "insert into insertd (name ,date,amntstatus,status,designation, city) values (?,?,?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(sqlQuery1);
                ps.setString(1,n);
                ps.setString(2,p);
                ps.setString(3,r);
                ps.setString(4,q);
                ps.setString(5,e);
                 ps.setString(6,f);
                ps.execute();
            }
        catch(SQLException e1)
            {
                System.out.println(e1);
            }
        response.sendRedirect("addMem.jsp");
   // RequestDispatcher rd2=request.getRequestDispatcher("addMem.jsp");
    //rd2.forward(request, response);
}
}