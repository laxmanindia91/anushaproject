//year auto populated in membership form
import com.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YearText extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String newid = request.getParameter("newid");//newid is parameter name which ois send from ajax data.newid contains the id of select option from dropdown member.
                try
                    {
                        Connection con=DBConnect.getConnection();
                        Statement stmt=con.createStatement();
			String sqlQuery1 = "select * from insertd where id='" + newid + "'";
                        ResultSet rs=stmt.executeQuery(sqlQuery1);
                        while(rs.next())
                          {   
                            out.print(rs.getString(3));
                            //out.print( "<input type='text' value='" + rs.getString(3) + "'>" );
                          }
                    }
                catch(SQLException e1)
                    {
		
                    }
    } 
}    
    
