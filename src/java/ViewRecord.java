import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;//library for dispacther,it will redirect to the given url
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewRecord extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		try{
                        response.setContentType("text/html");
                        PrintWriter out= response.getWriter();

                        out.print("<div class='container'>");
                        out.print("<center><h1>Recent Entered Record:</h1></center>");

                        out.print("<table class='table table-bordered'>");
                        out.print("<thead><th>Name</th><th>Amount</th><th>Amount Status</th><th>Date</th><th>cashier Name</th><th>Status</th></thead>");

                        out.print("<tr>");

                        out.print("<td>"+ request.getParameter("fname") +"</td>");

                        out.print("<td>"+ request.getParameter("amnt")+"</td>");

                        out.print("<td>"+ request.getParameter("amntStatus")+"</td>");

                        out.print("<td>"+ request.getParameter("date1") +"</td>");

                        out.print("<td>"+ request.getParameter("cashName") +"</td>"); 

                        out.print("<td>"+ request.getParameter("optradio") +"</td>");
                        out.println("</tr>");
                        out.println("</table>");
                        out.print("</div>");
	//request.setAttribute("userName",request.getParameter("fname"));
        response.sendRedirect("addData");
        //RequestDispatcher rd=request.getRequestDispatcher("addData");  
	///rd.include(request, response);//method may be include or forward 
		}
		catch(Exception e4)
			{
				e4.printStackTrace();
			}		
		}
		
	}