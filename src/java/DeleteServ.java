//servlet to delete fund
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

public class DeleteServ extends HttpServlet {
       @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); 
    }
public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException 
   {  
       res.setContentType("text/html");
       PrintWriter out = res.getWriter();
       Statement smt;
       String reciptno1 = req.getParameter("reciptno");
      // out.print(reciptno1);
        try
            { 
                Connection con=DBConnect.getConnection();
                smt = con.createStatement();
                smt.executeUpdate("UPDATE insertdata SET isActive= 0  WHERE reciptno=  " +reciptno1+ " ");
            }
        catch(SQLException sx)
            {
                out.println(sx);
            }
              out.print("<html><head>");
              out.print("<script type='text/javascript'>alert('Record deleted successfully!');</script>");
              out.print("</head><body></body></html>");
              res.sendRedirect("Viewdata");
          // RequestDispatcher rd1=req.getRequestDispatcher("Viewdata");
          // rd1.include(req, res); 
            
        }
}
                  