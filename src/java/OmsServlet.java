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

public class OmsServlet extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String n = request.getParameter("fname");
        String p = request.getParameter("amnt");
        String q = request.getParameter("amntStatus");
        String r = request.getParameter("date1");
        String s = request.getParameter("cashName");
        String t = request.getParameter("optradio");
        String w= request.getParameter("cityFund");
            try
                {
                    Connection con=DBConnect.getConnection();  
                    String sqlQuery = "insert into insertdata(name, amount, amountstatus, date, cashiername, status, cityFund) values (?,?,?,?,?,?,?)";
                    PreparedStatement ps= con.prepareStatement(sqlQuery);
                    ps.setString(1,n);
                    ps.setString(2,p);
                    ps.setString(3,q);
                    ps.setString(4,r);
                    ps.setString(5,s);
                    ps.setString(6,t);
                    ps.setString(7,w);
                    ps.execute();
                    
                }
            catch(Exception e1)
                {
                    System.out.println(e1);
                }
        response.sendRedirect("addfund.jsp");
    //RequestDispatcher rd=request.getRequestDispatcher("addfund.jsp");  
   // rd.forward(request, response);
    
}
}