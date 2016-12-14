import com.DBConnect;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MemberView extends HttpServlet {  
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    RequestDispatcher rd = request.getRequestDispatcher("header.jsp");
    rd.include(request,response);

        try{
                Connection con=DBConnect.getConnection();
                out.print("<div class='container' id='addMember' style='display:none;'>");
                out.print("<h1>Registration Form</h1><br>");
                out.print(" <form class='col-lg-6' action='insertMember' method='post' id='form1'>");
                out.print(" <input type='hidden' value='' name='updateid' class='update_id_form'>");
                out.print("<div class='form-group'>"
                                + "<label> Member Name:</label>"
                                + "<input type='text' class='form-control membrname datepicker'  name='name1' id='name1' placeholder='Enter your name'>"
                        + "</div><br>");
                out.print("<div class='form-group'>"
                                + "<label>Registration Year</label>"
                                + "<input type='text' class='form-control member' id='year1' name='date1'>"
                        + " </div><br>");
                out.print("<div class='dropdown'>"
                                + "<label>Registration Amount Status:</label><br>"
                                +"<select class='selectpicker memberamount selectopt2' name='opt1' id='opt1'>"
                                    +"<option value=''>select</option>"
                                    + "<option value='paid' >Paid</option>" 
                                    +"<option value='balance'>Balance</option>"
                                +"</select>"
                         +"</div><br>");
                out.print("<div class='form-group'>" +
"                           <label>Status:</label>" +
"                           <div class='radio radiobtn'>"
                                +"<label><input type='radio' value='active' class='radiobtn' name='myoptions' id='active'>Active</label>" 
                                +"<label><input type='radio' value='inactive' class='radiobtn' name='myoptions' id='inactive'>Inactive</label>" +
"                           </div>"
                        + "</div><br>");
                out.print("<div class='form-group'>" +
"                 <label>Designation:</label>" +
"                 <div class='dropdown'>" +
"                        <select class='selectpicker memberdes' name='opt' id='desig'>" +
"                                <option value='Normal' selected>Normal</option>" +
"                                <option value='cashier'>Cashier</option>" +
"                                <option value='Controller'>Controller</option>" +
"                                <option value='GeneralManager'>General Manager</option>" +
"                                <option value='President'>President</option>" +
"                        </select>" +
"                </div>" +
"            </div><br>");
               out.print("<div class='form-group'>"
                       +"<label>City</label>"
                       +"<input type='text' class='form-control city'  name='city' id='city' placeholder='Enter city'>" +
"               </div><br>");
                out.print(" <div>" +
"                        <input type='button' id='updtaebtnReplaced' class='btn btn-primary' value='Update'>" +
"               </div></form></div>");
    
                out.print("<div class='container' id='membertbl'>");
                out.print("<center><h1 id='headHide2'>View Records:</h1></center>");
                out.print("<div style='border:1px solid black;width:1080px;height:600px;overflow-y: scroll;'>");
                out.print("<table class='table table-bordered' id='table'>");
   
                Statement smt = con.createStatement();	
                ResultSet rs=smt.executeQuery("select * from insertd where isActive= 1 order by id DESC"); 
                ResultSetMetaData rsmd=rs.getMetaData();//getMetaData is used to get extra information
                //Int m = rsmd.getColumnName(1);
                String o= rsmd.getColumnName(2);
                String p = rsmd.getColumnName(3);
                String u = rsmd.getColumnName(4);
                String t = rsmd.getColumnName(5);
                String e = rsmd.getColumnName(6);
                String f= rsmd.getColumnName(7);
  
                //dynamic dropdown
                out.print("<div align='right'>"+
                    "<select id='selectval' class='selectoptSearch'>"+
                    "<option>"+rsmd.getColumnName(1)+"</option>"+
                    "<option>"+rsmd.getColumnName(2)+"</option>"
                    +"<option>"+rsmd.getColumnName(3)+"</option>"+
                    "<option>"+rsmd.getColumnName(4)+"</option>"+
                    "<option>"+rsmd.getColumnName(5)+"</option>"+
                    "<option>"+rsmd.getColumnName(6)+"</option>"+
                    "<option>"+rsmd.getColumnName(7)+"</option>"+
                    "</select>"+"&nbsp;<input type='text'placeholder='Search Here..'class='' id='filter'>"+
                "</div>");


                //To get column name from database		
                out.print("<thead>");
                    out.print("<th>"+rsmd.getColumnName(1)+"</th>");
                    out.print("<th>"+rsmd.getColumnName(2)+"</th>");
                    out.print("<th>"+rsmd.getColumnName(3)+"</th>");
                    out.print("<th>"+rsmd.getColumnName(4)+"</th>");
                    out.print("<th>"+rsmd.getColumnName(5)+"</th>");
                    out.print("<th>"+rsmd.getColumnName(6)+"</th>");
                    out.print("<th>"+rsmd.getColumnName(7)+"</th>");
                    out.print("<th id='actionhide'>Action</th>");
                out.print("</thead>");

                    while(rs.next())
                        {   
                            out.print("<tr id='row-"+rs.getString(1)+"'>");
                                out.print("<td>"+rs.getString(1)+"</td>");
                                out.print("<td value='name'>"+rs.getString(2)+"</td>");
                                out.print("<td value='date'>"+rs.getString(3)+"</td>");
                                out.print("<td value='amount'>"+rs.getString(4)+"</td>");
                                out.print("<td value='status'>"+rs.getString(5)+"</td>"); 
                                out.print("<td value='designation'>"+rs.getString(6)+"</td>");
                                out.print("<td value='city'>"+rs.getString(7)+"</td>");
                                /*out.print("<td colspan='2'><a href=''>Update</a>
                                <a href='xyz?id=' " +rs.getString("id")+ "'>Delete</a></td>");*/
                                /*out.print("<td colspan='2' id='actionColMem'><button id='updatemembtn'>"
                                    + "<a href='memUpdate?id=" + rs.getString(1)+ "'>Update</a>"
                                    + "</button>&nbsp;<button id='deletemembtn'>"
                                     + "<a href='memDelete?id=" + rs.getString(1)+ "'>Delete</a></button></td>");*/
                               out.print("<td colspan='2' id='hideActiontd1'><button class='updatemembtn' data-id='"+rs.getString(1)+"' data-name='"+rs.getString(2)+""
                                        + "' data-date='"+rs.getString(3)+"' data-amount='"+rs.getString(4)+"' data-status='"+rs.getString(5)+""
                                        + "' data-designation='"+rs.getString(6)+"' data-city='"+rs.getString(7)+"' type='button'>Update</button>&nbsp;"
                                       + "<button id='deletemembtn'><a href='memDelete?id=" + rs.getString(1)+ "'>Delete</a></button></td>");
                       

                            out.print("</tr>");
                            out.print("</div>");
                        }   
                     out.print("</table>");
               out.print("<table class='table table-bordered printbtn'>");
            out.print("<tr><td colspan='8' align='center'><button class='btn btn-primary'id='printmem'>Print</button></td></tr>");
            out.print("</table>");

              }
	catch (Exception e2)
              {
                   e2.printStackTrace();
              }
       }
} 