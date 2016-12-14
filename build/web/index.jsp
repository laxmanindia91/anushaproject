<% if(session.getAttribute("usrname")!= null){
    response.sendRedirect("addMem.jsp");
} %>
<!DOCTYPE html>
<html>
<head>
      <title>Login Page</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <%@include file="include.jsp" %>
</head>
<body>
     <div class="container">			
            <form method="post" id="homepage" action="logPage">
                    <h2>Login Page</h2>
                    <div class="form-group">
                        <label>User Name:</label>
                        <input type="text" class="form-control" id="usrname" name="usrname" placeholder="Enter User Name here..">
                    </div>
							
                    <div class="form-group">
                        <label>Password:</label>
                        <input type="password" class="form-control" id="pswd" name="pswd" placeholder="Enter Password here..">
                    </div>		
                    <button type="submit" class="btn btn-primary" id="loginbtn" name="loginbtn">Submit</button><br><br>
			
                    <div><a href="#" id="link1">Create new account</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="#" id="link2">Forgotten password?</a>
                    </div>
                    <!--div id="link1Place"></div-->
            </form>
	</div>
</body>
</html>
