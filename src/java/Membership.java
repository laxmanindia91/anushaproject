import com.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Membership extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
	String n1 = request.getParameter("mbno");
	String p1 = request.getParameter("amount");
	//String r1 = request.getParameter("mbno");
		//out.print(n1);
		try
                    {
                        Connection con=DBConnect.getConnection();
			String sqlQuery1 = "insert into membership(mobile,amount) values (?,?)";
			PreparedStatement ps= con.prepareStatement(sqlQuery1);
			ps.setString(1,n1);
			ps.setString(2,p1);
			ps.execute();
                    }
                catch(SQLException e1)
                {
		e1.printStackTrace();
                }     
//RequestDispatcher rd=request.getRequestDispatcher("homepage.html");
//rd.forward(request, response);
    } 
}    
    

 
