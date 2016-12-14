//Servlet to validate login page
import com.DBConnect;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPage extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
            response.setContentType("text/html");
            PrintWriter out= response.getWriter();
            String n1 = request.getParameter("usrname");
            String p1 = request.getParameter("pswd");
	try
        {
            Connection con=DBConnect.getConnection();	
            Statement statement = con.createStatement();
            String sqlQuery1 = "select usrname from logintbl where usrname = '"+ n1 +"' and password = '"+ p1 +"'";
            ResultSet rs = statement.executeQuery(sqlQuery1);
            int count = 0;
            String findUser="";
            while (rs.next())
            {
                    count++;
                    findUser = rs.getString(1);
            }
            if(count == 0)
            {
                response.sendRedirect("index.jsp");
            } 
            else 
            {
                HttpSession session = request.getSession();  
                session.setAttribute("usrname",findUser);//usrname is name of textfield in login form

                response.sendRedirect("addMem.jsp");
            }            
        }
        catch(SQLException e7)
        {
            out.println(e7);
        } 
    }
}