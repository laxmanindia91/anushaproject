//Servlet for view Fund.it will open after click on view fund dropdown.
import com.DBConnect;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class View extends HttpServlet {  
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
        try
            {
                Connection con=DBConnect.getConnection();
                 out.print("<div class='container'>");
                out.print("<div class='fund_Form' style='display:none;'>");
                    out.print( "<h2>Add Funds</h2>");
                    out.print("<div class='form-group'>");
                    out.print("<label>Fund Type:</label>");
                    out.print("<select class='selectpicker required selectopt' name='fundtype'>");
                    out.print("<option value='normal' selected>Normal</option>");
                    out.print("<option value='membership'>Membership</option>");
                    out.print("</select>");
                    out.print("</div>");

                    out.print("<form class='col-lg-6' action='addData' method='post' id='form2'>");
                    out.print("<input type='hidden' class='update_id_formFund' name='updaterecipt' value='' />");
                    out.print("<div class='form-group'>");
                    out.print("<label for='name'>Name:</label>");
                    out.print("<input type='text' class='form-control membrnameFund' id='name'  name='fname'  placeholder='Enter Name'>");
                    out.print("</div>");
                    out.print("<div class='form-group'>");
                                    out.print("<label for='amnt'>Amount:</label>");
                                    out.print("<input type='text' class='form-control Fundamount' id='amnt' name='amnt' onkeypress='return event.charCode >= 48 && event.charCode <= 57' placeholder='Enter Amount'>");
                                out.print("</div>");

                                out.print("<div class='form-group'>");
                                    out.print("<label>Amount Status:</label>");
                                        out.print("<select class='electpicker required Fundamntstatus' name='amntStatus' id='fundamountstatus'>");
                                            out.print("<option value='paid'>Paid</option>");
                                            out.print("<option value='cash'>Cash</option>");
                                        out.print("</select>");
                                out.print("</div>");

                                out.print("<div class='form-group'>");
                                    out.print("<label>Date:</label>");
                                    out.print("<input type='text' class='form-control FundDate' id='date1' name='date1'>");
                                out.print("</div>");

                                out.print("<div class='form-group'>");
                                    out.print("<label>Cashier's Name:</label>");	
                                        out.print("<select class='selectpicker required FundCash' name='cashName'>");
                                            out.print("<option>Must</option>");
                                            out.print("<option>Ketc</option>");
                                            out.print("<option>Rel</option>");
                                        out.print("</select>");
                                out.print("</div>");

                                out.print("<div>");
                                    out.print("<label for='status'>Status:</label>");
                                        out.print("<div class='radio'>");
                                            out.print("<label><input type='radio' id='active' value='active' class='Fundstatus' name='optradio'>Active</label>");
                                            out.print("<label><input type='radio' id='inactive' class='Fundstatus' value='inactive' name='optradio'>Inactive</label>");
                                        out.print("</div>");
                                out.print("</div>");

                                out.print("<div class='form-group'>");
                                    out.print("<Label>City</label>");
                                    out.print("<input type='text' class='form-control cityFund' name='cityFund' placeholder='Enter your city here..'>");
                                out.print("</div>");

                                out.print("<div>");
                                      out.print("<input  type='submit' id='btnFundSubmit' class='btn btn-primary' value='Submit'></button>");
                                       out.print("<button id='updtaebtnReplacedFund' type='button' class='btn btn-primary' style='display:none;'>Update</button>");
                                out.print("</div>");
                                out.print("</div></div><br>");
               
            //out.print("<thead><th>Reciept No</th><th>Name</th><th>Amount</th><th>Amount Status</th><th>Date</th><th>cashier Name</th><th>Status</th><th>Action</th></thead>");

            Statement smt = con.createStatement();
            ResultSet rs=smt.executeQuery("select * from insertdata order by reciptno DESC"); 
            ResultSetMetaData rsmd=rs.getMetaData();	//getMetaData is used to get extra information
            //Int m = rsmd.getColumnName(1);
              out.print("<div class='container' id='fundtbl'>");
            
            //dynamic dropdown
                out.print("<div align='right'>"+
                    "<select id='selectvalFund' class='selectoptSearchFund'>"+
                   "<option>Select any one</option>"+
                    "<option>"+rsmd.getColumnName(1)+"</option>"+
                    "<option>"+rsmd.getColumnName(2)+"</option>"
                    +"<option>"+rsmd.getColumnName(3)+"</option>"+
                    "<option>"+rsmd.getColumnName(4)+"</option>"+
                    "<option>"+rsmd.getColumnName(5)+"</option>"+
                    "<option>"+rsmd.getColumnName(6)+"</option>"+
                    "<option>"+rsmd.getColumnName(7)+"</option>"+
                    "<option>"+rsmd.getColumnName(8)+"</option>"+
                    "</select><input type='text'placeholder='Search Here..'class='' id='filterFund'></div>");
 
                //table
              
                out.print("<center><h1 id='hideH1'>View Records:</h1></center>");
                out.print("<div style='border:1px solid black;width:1080px;height:600px;overflow-y: scroll;id='scrollhide'>");
                out.print("<table class='table table-bordered' id='table1'>");
            //To get column name from database		
            out.print("<thead>");
            out.print("<th>"+rsmd.getColumnName(1)+"</th>");
            out.print("<th>"+rsmd.getColumnName(2)+"</th>");
            out.print("<th>"+rsmd.getColumnName(3)+"</th>");
            out.print("<th>"+rsmd.getColumnName(4)+"</th>");
            out.print("<th>"+rsmd.getColumnName(5)+"</th>");
            out.print("<th>"+rsmd.getColumnName(6)+"</th>");
            out.print("<th>"+rsmd.getColumnName(7)+"</th>");
            out.print("<th>"+rsmd.getColumnName(8)+"</th>");
            out.print("<th id='actionhide'>Action</th>");
            out.print("</thead>");

                while(rs.next())
                        {
                            //values
                            out.print("<tr id='onlyDataFund'><td>"+rs.getString(1)+"</td>");
                            out.print("<td>"+rs.getString(2)+"</td>");
                            out.print("<td>"+rs.getString(3)+"</td>");
                            out.print("<td>"+rs.getString(4)+"</td>"); 
                            out.print("<td>"+rs.getString(5)+"</td>"); 
                            out.print("<td>"+rs.getString(6)+"</td>"); 
                            out.print("<td>"+rs.getString(7)+"</td>");
                            out.print("<td>"+rs.getString(8)+"</td>");

                           /*out.print("<td colspan='2' id='actionColFund'><button id='updatebtn'>"
                                    + "<a href='update?reciptno=" +rs.getString(1)+ "'>Update</a>"
                                    + "</button>&nbsp;<button id='deletebtnFund'><a href='delete?reciptno=" + rs.getString(1)+ "'>Delete</a>"
                                    + "</button></td></tr>");*/
                           out.print("<td colspan='2'id='hideActiontd'><button class='updatebtnFund' data-reciptno='"+rs.getString(1)+"' data-name='"+rs.getString(2)+""
                                + "' data-amount='"+rs.getString(3)+"' data-amountstatus='"+rs.getString(4)+"' data-date='"+rs.getString(5)+""
                                + "' data-casheirname='"+rs.getString(6)+"'data-status='"+rs.getString(7)+"' data-cityfund='"+rs.getString(8)+"' type='button'>Update</button>"
                                   + "&nbsp;<button id='deletebtnFund'><a href='delete?reciptno=" + rs.getString(1)+ "'>Delete</a></button></td>");
                           out.print("</tr>");
			}
                out.print("</table>");
               out.print("<table class='table table-bordered printbtn'>");
                            out.print("<tr><td colspan='9' align='center'><button class='btn btn-primary'id='print'>"
                                    + "Print</button></td></tr>");								
		 out.print("</table></div>");
               // RequestDispatcher rd1 = request.getRequestDispatcher("footer.jsp");
                //rd1.include(request,response);
              }
        catch (Exception e2)
             {
                e2.printStackTrace();
             }  
         }
}
 
