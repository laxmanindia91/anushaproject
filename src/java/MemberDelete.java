//DELETE SERVLET FOR MEMBER
import com.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MemberDelete extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
{  
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	Connection con;
	Statement smt;
	String id1 = req.getParameter("id");
            try
                { 
                   con=DBConnect.getConnection();			
                   smt = con.createStatement();
                   smt.executeUpdate("UPDATE insertd SET isActive= 0 WHERE id=  " +id1+ " ");
                   
		}
            catch(SQLException sx)
                {
                    out.println(sx);
		}
             out.print("<html><head>");
             out.print("<script type='text/javascript'>alert('Record deleted successfully!');</script>");
             out.print("</head><body></body></html>");
    RequestDispatcher rd=req.getRequestDispatcher("MemView");
    rd.include(req, res);
}   
}
								