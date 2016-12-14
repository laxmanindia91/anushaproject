function submitData()
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
        }
function myForm(){
                      $.ajax({
			url:'addMem.html',
			success:function(result){
                        $("#formDiv").html(result);}
                        });
        }
                   
function myTable(){
                      $.ajax({
                          type:'post',
			url :'memView1',
			success:function(result){
                          $("#tableDiv").html(result);}
                        });
        }
                  
function tabs(){
                $('a').click(function(){
                     var url = $(this).data('href');
                     $.ajax({
				url:url,
				success: function(result){
                                        $('#formDiv').hide();
                                        $('#dropD').hide();
                                        $("#formDiv").show().html(result);}    
                            });          
                    });  
        }
             
function hidetbl(){
                    $('#tableDiv').hide();
        }
             
function showMem(){
                      $.ajax({
			url :'memView1',
			success:function(result){
                          $("#tableDiv").show().html(result);}
                        });
        }
                  
function ShowFund(){
                    $.ajax({
			url :'belowFundTbl',
			success:function(result){
                        $("#tableDiv").hide();
                          $("#tableDiv").show().html(result);}
                        });
        }
function myFunction() {
                      window.print();	
        }
                     
function myFunction1() {
                        window.print();	
        }
                    
function myoption1(){
             
                    $.ajax({
                        url:'addFund.html',
                        success: function(result){
                        $("#formDiv").html(result);  }
                     });
        }
        
function getMem1(){
                 $.ajax({
                        url:'Membership.html',
                        success: function(result){   
                        $("#tableDiv").hide();
                        $("#formDiv").html(result);  }
                             });
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

jQuery(document).ready(function($){
                            myForm();
                            myTable();
                            tabs();
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
               if(value== 'normal')
                    {
                        myoption1();
                        ShowFund();
                     }  
                else if(value== "Membership")
                    {
                        getMem1();    
                    }
        });
            
$('body').on('click','#printmem',function(){
			myFunction1 ();
	}); 
        
$('body').on('click','#insertbtn',function(){
                     var dataString = $('#form1').serialize();//get form and serialize its fields
                     var method = $('#form1').attr('method');//get (method attribute)value of form
                     var ajaxurl = $('#form1').attr('action');//get action attribute of form
                      //alert(dataString+' '+method+' '+ajaxurl);
			$.ajax({
				type: method,
				data: dataString,
                                url: ajaxurl,
                                success: function(result){
                                $("#tableDiv").html(result);
                                $('#form1')[0].reset();//clear fields of form after view table
                                                     //   return false;
                                                 }
                            });
        });
        
$('body').on('click','#btnFundSubmit',function(){
                     var dataString = $('#form2').serialize();//get form and serialize its fields
                      var method = $('#form2').attr('method');//get (method attribute)value of form
                      var ajaxurl = $('#form2').attr('action');//get action attribute of form
                      //alert(dataString+' '+method+' '+ajaxurl);
			$.ajax({
				type: method,
				data: dataString,
                                url: ajaxurl,
                                success: function(result){
                                $("#tableDiv").html(result);
                                $('#form2')[0].reset();
                               // return false;
                            }
                            });
        });
//update button for member        
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
                            var dataString = $('#form1').serialize();
                            var method = $('#form1').attr('method');
                            var rowid = '#'+$(this).data('rowid');
                            $.ajax({
                                    url:'memUpdate2',
                                    type: method,
                                    data: dataString,
                                    success: function(result){
                                            $(rowid).html(result);
                                            $('#form1')[0].reset();
                                       //alert("Record updated successfully!");
                                  }
				});
        });
        
 //update button for fund       
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
                            var dataString = $('#form2').serialize();
                            var method = $('#form2').attr('method');
                            var rowrecipt = '#'+$(this).data('rowrecipt');
                            $.ajax({
                                    url:'update1',
                                    type: method,
                                    data: dataString,
                                    success: function(result){
                                            $(rowrecipt).html(result);
                                            $('#form2')[0].reset();}
				});
        });   
//seacrh with column for View member       
$('body').on('change','select.selectoptSearch',function(){
                        var a = $(this).val();
                        var v1 = $('#filter').val();
                        if(a == null || v1 == "")
                        {
                            return false;
                        }
                        else
                        {
                            var dataString = 'a='+a+'&v1='+v1;
                                $.ajax({
                                        url:'search',
                                        data: dataString,
                                        type:'post',
                                        success: function(result){
                                               // alert('Data Recieved : ' + result);
                                               $('#tableDiv').hide();
                                               $('#formDiv').hide();
                                               $('#tableDiv').show().html(result);}
                                           
                                    });
                        }
        });
//seacrh with column for View Fund 
$('body').on('change','select.selectoptSearchFund',function(){
                        var optionvalue = $(this).val();
                        var textvalue= $('#filterFund').val();
                        if(optionvalue == null || textvalue == "")
                        {
                            return false;
                        }
                        else
                        {
                            var dataString = 'optionvalue='+optionvalue+'&textvalue='+textvalue;
                                $.ajax({
                                        url:'SearchFund',
                                        data: dataString,
                                        type:'post',
                                        success: function(result){
                                               // alert('Data Recieved : ' + result);
                                               $('#tableDiv').hide();
                                               $('#formDiv').hide();
                                               $('#tableDiv').show().html(result);}
                                           
                                    });
                        }
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
 //update on VIEW MEMBER
$('body').on('click','.updatemembtn',function(){
                            var id= $(this).data('id');
                           //$('.update_id_form').val(id);
                            var name = $(this).data('name');
                            var date = $(this).data('date');
                            var amount = $(this).data('amount');
                            var status = $(this).data('status');
                            var designation = $(this).data('designation');
                            var city = $(this).data('city');
                       $.ajax({
                            type: 'post',
                            url: 'addMem.html',
                            success: function(result){
                               $('#formDiv').html(result);
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
                                $('#updtaebtnReplaced').attr('data-updateid',id).css('display','block');
                                $('.update_id_form').val(id);
                                //alert(id);
                            }   
                 });         
                          
        });
$('body').on('click','#updtaebtnReplaced',function(){
                            var dataString = $('#form1').serialize();
                            //alert(dataString);
                            var method = $('#form1').attr('method');
                            var rowid = '#'+$(this).data('rowrid');
                            $.ajax({
                                    url:'memUpdate2',
                                    type: method,
                                    data: dataString,
                                    success: function(result){
                                       $(rowid).html(result);   
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
                       $.ajax({
                            type: 'post',
                            url: 'addFund.html',
                            success: function(result){
                                $('#formDiv').html(result);
                                $('#name').val(name);
                                $('#amnt').val(amount);
                                $("#fundamountstatus").find('option').each(function(){
                                    //alert($(this).val());
                                    //alert(amountstatus);
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
                                
                            }   
                 });         
                          
        });
$('body').on('click','#updtaebtnReplacedFund',function(){
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
                                    }
				});
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

});

                     
      

                           
                             