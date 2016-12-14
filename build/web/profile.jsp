 <%@include file="header.jsp" %>
 <div class="container">
    <form method="post" action="Profile">
                 <h2>Edit Profile</h2>
                 <div class="form-group">
                        <label>First Name</label>
                        <input type="text" class="form-control" id="usrname" name="usrname" placeholder="Enter User Name here..">
                 </div>
                 <div class="form-group">
                        <label>Mobile Number</label>
                        <input type="text" class="form-control" id="phno" name="phno" placeholder="Enter Mobile number here..">
                 </div>
                 <div class="form-group">
                        <label>City</label>
                        <input type="text" class="form-control" id="phno" name="city" placeholder="Enter City here..">
                 </div>
                 <div class="form-group">
                        <label>Address</label>
                        <textarea rows="5" cols="6" class="form-control" id="address" name="address" placeholder="Enter Address here.."></textarea> 
                </div>
                <div><button type="submit" class="btn btn-primary" id="saveProfile" name="saveProfile">Save Profile</button><br><br></div>
    </form>
</div>
<%@include file="footer.jsp" %>