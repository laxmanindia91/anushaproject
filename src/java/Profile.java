//Servlet to add data related to Fund into database
import com.DBConnect;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Profile extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String username = request.getParameter("usrname");
        String phoneno= request.getParameter("phno");
        String city= request.getParameter("city");
        String address = request.getParameter("address");
        
            try
                {
                    Connection con=DBConnect.getConnection();  
                    String sqlQuery = "insert into profille(name, phoneno, city, address) values (?,?,?,?)";
                    PreparedStatement ps= con.prepareStatement(sqlQuery);
                    ps.setString(1,username);
                    ps.setString(2,phoneno);
                    ps.setString(3,city);
                    ps.setString(4,address);
                    ps.execute();
                }
            catch(Exception e1)
                {
                    System.out.println(e1);
                }
             response.sendRedirect("profile.jsp"); 
    //RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");  
    //rd.include(request, response);
}
}