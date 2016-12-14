<%@ include file="header.jsp" %>
<div class="container">
    <form class="col-lg-6" action="addData" method="post" id="form2" onsubmit="btnfund.disabled=true; return true;">
        <input type="hidden" value="" name="updaterecipt" class="update_id_formFund"/>
        <div id="changeForm">
            <h2>Add Funds</h2>
            <div>
                <label>Fund Type</label>
                <select class="selectpicker selectopt" >
                    <option value='normal' selected>Normal</option>
                    <option value='Membership'>Membership</option>
                </select>
            </div>
        </div>   
	<div class="form-group">
                <label for="name">Name:</label>
		<input type="text" class="form-control membrnameFund" id="name" name="fname"  placeholder="Enter name">
	</div>
	<div class="form-group">
		<label for="amnt">Amount:</label>
		<input type="text" class="form-control Fundamount" id="amnt" name="amnt" onkeypress="return event.charCode >= 48 && event.charCode <= 57" placeholder="Enter Amount">
	</div>
	<div class="form-group">
		<label>Amount Status:</label>
                <select class="selectpicker required Fundamntstatus" id="fundamountstatus" name="amntStatus">
                        <option value="">Select</option>
			<option value="paid">Paid</option>
			<option value="cash">Cash</option>
		</select>
        </div>
        <div class="form-group">
		<label>Year:</label>
		<input type="text" class="form-control FundDate" id="date1" name="date1">
	</div>
	<div class="form-group">
		<label>Cashier's Name:</label> 	
		<select class="selectpicker required FundCash" name="cashName">
			<option>Must</option>
			<option>Ketc</option>
			<option>Rel</option>
		</select>
	</div>
	<div class="form-group">
		<label>Status:</label>
		<div class="radio">
                        <label><input type="radio"  id="active" class="Fundstatus" value="active" name="optradio">Active</label>
                        <label><input type="radio" value="inactive"  class="Fundstatus" id="inactive" name="optradio">Inactive</label>
                </div>
	</div>
        <div class="form-group">
		<label>City</label>
		<input type="text" class="form-control cityFund" name="cityFund">
	</div>
				
	<div>
                <input type="submit" id="btnFundSubmit" class="btn btn-primary btnsub" name="btnfund" value="Submit"/>
                <input type="submit" id="updtaebtnReplacedFund" class="btn btn-primary" value="Update" style="display:none;"/>
        </div>
</form>
</div>
<div><jsp:include page="belowFundTbl"/></div>
<div><%@ include file="footer.jsp" %></div>      
 