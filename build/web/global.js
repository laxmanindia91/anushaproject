/*function submitData()
{
        var name = $("#memberNames option:selected").html();
        var ajaxurl = $('#form3').attr('action');
                   $('#member_name').val(name);
                                    $.ajax({
                                        type: 'post',
                                        data: name,
					url: ajaxurl,
					success: function(result){
                                                $('#tableDiv').html(result);
                                                $('#form3')[0].reset();
                                                $('#server_msg_modal').modal('show');}
                                        });
        }*/
function myFunction() {
                      window.print();	
        }                
function myFunction1() {
                        window.print();	
        }           
  

function searchTable(inputVal)
				{
				var table = $('#table');//table is id of table
				table.find('tr').each(function(index, row)
					{

					var a= $(row).find('td');
		
				if(a.length>0)
					{
					var found = false;
					a.each(function(index, td)
					{
				var regExp = new RegExp(inputVal, 'i');
				
				if(regExp.test($(td).text()))
				{
				//alert($(td).text());
					found = true;
					return false;
				}
			});
			if(found == true)$(row).show();else $(row).hide();
		}
	});
}
function searchTable1(inputVal)
				{
				var table = $('#table1');//table1 is id of table
				table.find('tr').each(function(index, row)
					{

					var a= $(row).find('td');
		
				if(a.length>0)
					{
					var found = false;
					a.each(function(index, td)
					{
				var regExp = new RegExp(inputVal, 'i');
				
				if(regExp.test($(td).text()))
				{
				//alert($(td).text());
					found = true;
					return false;
				}
			});
			if(found == true)$(row).show();else $(row).hide();
		}
	});
}
function getMem1(){
    alert('hello');
                    window.location="Membership.jsp";
                $.ajax({
                        type:'post',
                        url:'viewMemDropDown',
                        success: function(result){ 
                            //alert(result);
                        $("#dropD").html(result);  }
                    });
               $.ajax({
                        type:'post',
                        url:'cashierName',
                        success: function(result){  
                        $("#cashierDiv").html(result);}
                    });
                   
          } 

jQuery(document).ready(function($){
 /*$('body').on('load','addMem.jsp',function() { 
             alert("year");
             $('#year1').datepicker({
                         dateFormat: 'yy',
                         changeYear: true,
                         showButtonPanel: true,
                         yearRange: "2000:2017",
                         onClose: function(dateText, inst) {
                         var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                         $(this).val($.datepicker.formatDate('yy', new Date(year,1)));}
                     });
        });  */   
//simple search for view member                            
$('body').on('keyup','#filter',function()
	{
				searchTable($(this).val()); 	
	}); 
//simple search for view fund   
$('body').on('keyup','#filterFund',function()
	{
				searchTable1($(this).val()); 	
	});
	      
$('body').on('change','.selectopt2',function(){
                    var value2 = $(this).val();
                    if($(this).val()=='paid')
                    {
                        $("#active").prop("checked", true);
                        $("#inactive").prop("checked", false);
                     }
                    if($(this).val()=='balance')
                    {
                        $("#active").prop("checked", false);
                        $("#inactive").prop("checked", true);
                    }
        }); 

$('body').on('click','#print',function(){
			myFunction();
        });
    
$('body').on('change','.selectopt',function(){
               var value = $(this).val();
                alert(value);
               if(value== 'normal')
                    {
                       // alert("normal");
                        myoption1();
                        ShowFund();
                     }  
                else if(value== "Membership")
                    {
                        //alert('hello');
                    getMem1();
                    }
        });
            
$('body').on('click','#printmem',function(){
			myFunction1 ();
	}); 
        

$('body').on('change','.Fundamntstatus',function(){
                    var value3 = $(this).val();
                    if($(this).val()=='paid')
                    {
                        $("#active").prop("checked", true);
                        $("#inactive").prop("checked", false);
                     }
                    if($(this).val()=='cash')
                    {
                        $("#active").prop("checked", false);
                        $("#inactive").prop("checked", true);
                    }
        }); 
$('body').on('change','#memberNames',function(){
                var newid = $(this).val();
                $('.update_id_membership1').val(newid);
                    $.ajax({
                                url:'yearText',
                                data: 'newid='+newid,
                                success: function(result){
                                $('#yearField').html("<input type='text' value='" + result + "'>");
                                $('#fromyear').html("<input type='text' value='" + result + "'>"); 
                                $('#fromto').html("<input type='text' value='" + (+result+ +1) + "'>");}
                            });
                    
 });
//for update member(below form)
 $('body').on('click','.updatebtn',function(){
                            $('#insertbtn').hide();
                            $('#updtaebtnReplaced').show();
                            var id= $(this).data('id');
                            $('.update_id_form').val(id);
                            var name = $(this).data('name');
                            var date = $(this).data('date');
                            var amount = $(this).data('amount');
                            var status = $(this).data('status');
                            var designation = $(this).data('designation');
                            var city = $(this).data('city');
                            
                            $('#updtaebtnReplaced').attr('data-rowid','row'+id);
                            $(".membrname").val(name);
                            $(".member").val(date);
                            $(".memberamount").find('option').each(function(){
                                    if($(this).val()==amount) 
                                    {
                                        $(this).prop('selected',true);
                                    }
                                });  
                            $(".radiobtn").removeAttr('checked').filter('[value='+status+']').attr('checked', true).click();
                            $(".memberdes ").find('option').each(function(){
                                    if($(this).val()==designation) 
                                    {
                                        $(this).prop('selected',true);
                                    }
                                });
                            $("#city").val(city);
          }); 
      $('body').on('click','#updtaebtnReplaced',function(){
                            $("#form1").removeAttr("action");
                            var dataString = $("#form1").serialize();
                            var rowid = '#'+$(this).data('rowid');
                            //alert(dataString);
                            $.ajax({
                                    type:'post',
                                    data: dataString,
                                    url: 'memUpdate2',
                                    success: function(result){
                                            $(rowid).html(result);
                                            $('#form1')[0].reset();
                                            //window.loaction.href="addMem.jsp";
                                          // location.reload();
                                  }
				});
     
}); 
//update button for fundview1(below form)
$('body').on('click','.updatebtnFund',function(){
                            $('#btnFundSubmit').hide();
                            $('#updtaebtnReplacedFund').show();
                            var reciptno = $(this).data('reciptno');
                            $('.update_id_formFund').val(reciptno);
                            var name = $(this).data('name');
                            var amount = $(this).data('amount');
                            var amountstatus = $(this).data('amountstatus');
                            var date = $(this).data('date');
                            var casheirname = $(this).data('casheirname');
                            var status = $(this).data('status');
                            var city = $(this).data('cityfund');
                            
                            $('#updtaebtnReplacedFund').attr('data-rowrecipt','row'+reciptno);
                            $(".membrnameFund").val(name);
                            $(".Fundamount").val(amount);
                            $("#fundamountstatus").find('option').each(function(){
                                    if($(this).val()== amountstatus) 
                                    {
                                        $(this).prop('selected',true);
                                    }
                                }); 
                            $("#date1").val(date);
                            $('.FundCash').find('option').each(function(){
                                    if($(this).val()==casheirname) 
                                    {
                                        $(this).prop('selected',true);
                                    }
                                }); 
                            $('.Fundstatus[value='+status+']').attr('checked','checked');
                            $(".cityFund").val(city);
            }); 
$('body').on('click','#updtaebtnReplacedFund',function(){
                            $('#form2').removeAttr("action");
                            var dataString = $('#form2').serialize();
                            var method = $('#form2').attr('method');
                            var rowrecipt = '#'+$(this).data('rowrecipt');
                            $.ajax({
                                    url:'update1',
                                    type: method,
                                    data: dataString,
                                    success: function(result){
                                            $(rowrecipt).html(result);
                                            $('#form2')[0].reset();
                                        window.loaction.href="addfund.jsp";}
				});
        }); 
//update on VIEW MEMBER
$('body').on('click','.updatemembtn',function(){
                           
                            var id= $(this).data('id');
                            $('.update_id_form').val(id);
                            var name = $(this).data('name');
                            var date = $(this).data('date');
                            var amount = $(this).data('amount');
                            var status = $(this).data('status');
                            var designation = $(this).data('designation');
                            var city = $(this).data('city');
                            
                                $('#addMember').show();
                                $('#membertbl').hide();
                                $('#insertbtn').hide();//submit btn
                                $('#updtaebtnReplaced').show();//btn replaced
                                $('#name1').val(name);
                                $('#year1').val(date);
                                $('#opt1').find('option').each(function(){
                                    if($(this).val()==amount) 
                                    {
                                        $(this).prop('selected',true);
                                    }
                                });
                                $('.radiobtn[value='+status+']').attr('checked','checked');
                                $('#desig').find('option').each(function(){
                                    if($(this).val()==designation) 
                                    {
                                        $(this).prop('selected',true);
                                    }
                                });
                                 $('#city').val(city);
                                $('#insertbtn').css('display','none');
                                $('#updtaebtnReplaced').attr('data-rowrid','row-'+id).css('display','block');
                                $('.update_id_form').val(id);
             });  
                    $('body').on('click','#updtaebtnReplaced',function(){
                            var dataString = $('#form1').serialize();
                            var rowid = '#'+$(this).data('rowrid');
                                  $.ajax({
                                    url:'memUpdate2',
                                    type: 'POST',
                                    data: dataString,
                                    success: function(result){
                                       $(rowid).html(result);
                                        $('#form1')[0].reset();
                                        window.location.href="MemView";
                                    }
				});
        });
//update on (VIEW FUND)
$('body').on('click','.updatebtnFund',function(){
                            var reciptno = $(this).data('reciptno');
                            $('.update_id_formFund').val(reciptno);
                            var name = $(this).data('name');
                            var amount = $(this).data('amount');
                            var amountstatus = $(this).data('amountstatus');
                            var date = $(this).data('date');
                            var casheirname = $(this).data('casheirname');
                            var status = $(this).data('status'); 
                            var cityFund = $(this).data('cityfund');
                            //alert(cityFund);
                               $('#fundtbl').hide();
                               $('.fund_Form').show();
                                 $('.Viewmembertbl').hide();
                                $('#name').val(name);
                                $('#amnt').val(amount);
                                $("#fundamountstatus").find('option').each(function(){
                                    if($(this).val()==amountstatus) 
                                    {
                                        $(this).prop('selected',true);
                                    }
                                }); 
                                $('#date1').val(date);
                                $('.FundCash').find('option').each(function(){
                                    if($(this).val()==casheirname) 
                                    {
                                        $(this).prop('selected',true);
                                    }
                                }); 
                                $('.Fundstatus[value='+status+']').attr('checked','checked');
                                 $('.cityFund').val(cityFund);
                                
                                $('#btnFundSubmit').css('display','none');
                                $('#updtaebtnReplacedFund').attr('data-updateceipt',reciptno).css('display','block');
                                $('.update_id_formFund').val(reciptno);
                                
                                        
        });
$('body').on('click','#updtaebtnReplacedFund',function(){
                            $('#form2').removeAttr("action");
                            var dataString = $('#form2').serialize();
                            var rowrecipt = '#'+$(this).data('rowrecipt');
                            $.ajax({
                                    type: 'post',
                                    url:'update1',
                                    data: dataString,
                                    success: function(result){
                                       $(rowrecipt).html(result);
                                       $('#form2')[0].reset();
                                       window.location.href = "Viewdata";
                                    }
				});
        });
 });

                     
      

                           
                             