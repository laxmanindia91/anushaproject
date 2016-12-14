<%@ include file="header.jsp" %>
<div class="container">
    <form class="col-md-6" method="post" action="membership" id="form3">
         <input type="hidden" value="" name="HidenField" class="update_id_membership1"/>
         <div id="changeForm">
            <h2>Membership Form</h2>
            <div>
                <label>Fund Type</label>
                <select class="selectpicker selectopt" >
                    <option value='normal'>Normal</option>
                    <option value='Membership' selected>Membership</option>
                </select>
            </div>  
        </div>
	<div class="form-group formfields">
			<label>Member Name:</label>
                        <div id="dropD"></div>
                        <div><jsp:include page="viewMemDropDown"/></div>
	</div> 
        <div class="form-group formfields">
			<label for="Registeryear">Register Year:</label>
                        <div id="yearField"><input type="text" class="form-control" id="yearvalue"/></div>
	</div>
	<div class="form-group formfields">
			<label for="mobileno">Mobile Number:</label>
			<input type="text" name="mbno" class="form-control" id="mbno" onkeypress="return event.charCode >= 48 && event.charCode <= 57" placeholder="Enter Mobile Number">
	</div>
	<div class="form-group formfields">
                        <label for="fundyear">Fund Year:</label>
                        <div class="fundyear">
                             <div id="fromyear"><input class="form-control" type="text"/></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>To</b>
                             <div id="fromto"><input  class="form-control"type="text"/></div>
                        </div>        
        </div>
        <div class="form-group formfields">
                        <label>Cashier Name:</label>
                        <div id="cashierDiv"></div>
                        <div ><jsp:include page="cashierName"/></div>
        </div>
	<div class="form-group formfields">
                        <label for="amount">Amount:</label>
			<input type="text" class="form-control" name="amount" value="500" disabled="disabled">
	</div>
        <div>
                        <button id="id1" type="button" class="btn btn-primary" onClick='submitData()'>Submit</button>
        </div>                                         
        </form>	                        
    </div>
<div class="modal fade" id="server_msg_modal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Membership</h4>
      </div>
      <div class="modal-body">
        <form>
            <div class="form-group">
                <label for="member">Member Name:</label>
                <input type="text" class="form-control" id="member_name">
            </div> 
            <div class="form-group">
                <label for="member">Amount:</label>
                <input type="text" value="500" class="form-control" id="member_amount">
            </div> 
        </form>       
   </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
        </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal-->
<%@ include file="footer.jsp" %>
