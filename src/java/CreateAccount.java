//Servlet to Create account
import com.DBConnect;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;//library for dispacther,it will redirect to the given url
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccount extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
            response.setContentType("text/html");
            PrintWriter out= response.getWriter();
                
		String n1 = request.getParameter("usrname1");
		String p1 = request.getParameter("pswd1");
	try
        {
            Connection con=DBConnect.getConnection();
            Statement statement = (Statement) con.createStatement();
            String sqlQuery1 = "select * from logintbl where usrname ='" + n1 +"' and password ='" + p1 +"'";
            ResultSet rs = statement.executeQuery(sqlQuery1);
            int counter = 0;
            while(rs.next())
            {
                counter++; 
            }
            if(counter == 0)
            {
                String sqlQuery2= "insert into logintbl(usrname , password) values (?,?)";
                PreparedStatement ps= con.prepareStatement(sqlQuery2);
                ps.setString(1,n1);
                ps.setString(2,p1);
                ps.execute();
                out.println("<h4 align='center'>Account Created!Now you can Login</h4>");
                response.sendRedirect("index.jsp");
                //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                //rd.include(request, response);
            }	
            else
            {
                  response.sendRedirect("createaccount");
                //RequestDispatcher rd=request.getRequestDispatcher("createaccount");
                //rd.include(request, response);
            }
        }
        catch(Exception e6)
        {
            System.out.println(e6);
        }
    }
}