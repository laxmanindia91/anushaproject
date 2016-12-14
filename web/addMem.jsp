<%@ include file="header.jsp" %>
<div class="container">
    <h1>Registration Form</h1><br>
    <form class="col-lg-6" action="insertMember" method="post" id="form1">
            <input type="hidden" value="" name="updateid" class="update_id_form"/>
            <div class="form-group">
                <label> Member Name:</label>
                <input type="text" class="form-control membrname datepicker"  name="name1" id="name1" placeholder="Enter your name">
            </div><br>
            <div class="form-group">
                <label>Registration Year</label>
                <input type="text" class="form-control member"  id="year1" name="date1">
            </div><br>
            <div class="dropdown">
                <label>Registration Amount Status:</label> <br>
                <select class="selectpicker memberamount selectopt2" name="opt1" id="opt1">
                        <option value="" >select</option>
                        <option value="paid" >Paid</option>
                        <option value="balance">Balance</option>
                </select>
            </div><br>
            <div>
                  <label for="Status">Status:</label>
                  <div class="radio radiobtn">
                        <label><input type="radio" value="active" class="radiobtn"   name="myoptions" id="active">Active</label>
                        <label><input type="radio" value="inactive" class="radiobtn"  name="myoptions" id="inactive">Inactive</label> 
                  </div>
            </div><br>
            <div>
                 <label>Designation:</label>
                 <div class="dropdown">
                        <select class="selectpicker memberdes" name="opt" id="desig">
                                <option value="Normal" selected>Normal</option>
                                <option value="cashier">Cashier</option>
                                <option value="Controller">Controller</option>
                                <option value="GeneralManager">General Manager</option>
                                <option value="President">President</option>
                        </select>
                </div>
            </div><br>
            <div class="form-group">
                    <label>City</label>
                    <input type="text" class="form-control city"  name="city" id="city" placeholder="Enter city">
            </div><br>
            <div>
                    <input type="submit" id="insertbtn" class="btn btn-primary btnsub" name="btnmem" value="Submit"/>
                    <input type="submit" id="updtaebtnReplaced" class="btn btn-primary" value="Update" style="display:none;"/>
            </div>
</form>
</div>
<div><jsp:include page="memView1"/></div><!--include servlet into jsp-->
<div><%@ include file="footer.jsp" %></div>

