<% if(session.getAttribute("usrname")== null){
    response.sendRedirect("index.jsp");
} %>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <%@include file="include.jsp" %>
        <link  rel="stylesheet" href="style.css">
        <script src="global.js"></script>
        <script>
    jQuery(document).ready(function(){  
        var backcheck = $('#backcheck').val();
        if(backcheck=='no')
        {
           $('#backcheck').val('yes');
        }
        if(backcheck=='yes')
        {
            window.location.reload();
        }
            });
            </script>
    </head>
<body>
    <input type="hidden" id="backcheck" value="no">
	<div class="container">
            <div class="row col-sm-12" id="header1">
                    <div class="col-sm-3" align="center" style="border: 1px solid black; height: 58px;padding-top: 20px; font-size: x-large;"><%="Hello "+session.getAttribute("usrname") %></div>
                    <div class="col-sm-6" style="border: 1px solid black;"><h3 align="center">Organisation Management System</h3></div>
                    <div class="col-sm-3" align="center" style="border: 1px solid black;"><h3><a href="Logout">logout</a></h3></div>
            </div>
            <div class="row col-sm-12" id="header2">
                    <div class="col-sm-2" style="border: 1px solid black;"><h5 align="center"><a href="profile.jsp">Profile</a></h5></div>
                    <div class="col-sm-3" style="border: 1px solid black;"><h5 align="center"><a href="addMem.jsp">Add Member</a></h5></div>
                    <div class="col-sm-3" style="border: 1px solid black;"><h5 align="center"><a href="addfund.jsp">Add Fund</a></h5></div>
                    <div class="col-sm-2" style="border: 1px solid black;"><h5 align="center"><a href="MemView">View Member</a></h5></div>
                    <div class="col-sm-2" style="border: 1px solid black;"><h5 align="center"><a href="Viewdata">View Fund</a></h5></div>
            </div>
	</div>
