<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Example of Bootstrap 3 Disabled Fieldsets</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
<style type="text/css">
     
    .bs-example{
    	margin: 20px;
    }
</style>

	<script type="text/javascript">
		$(document).ready(function() {
			       $("input[type='text']").click(function(){
			    	       	$(this).removeAttr('readonly');
			       });
			       
			       $("input[type='text']").blur(function(){
		    	       	$(this).attr('readonly', 'readonly');
		       }); 
			
		});
	</script>	
</head>
<body>
<br/><br/>
<fieldset style="margin-left: 100px;">
<LEGEND><b style="color:blue;">Step One: Personal Information</b></LEGEND>
<div class="bs-example" style="width: 50%;margin-left: 100px;">
	<ff:form id="editForm" method="post" class="form-horizontal" commandName="ccustomer">
            <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-2">Email</label>
                <div class="col-xs-10">
                    <ff:input class="form-control" id="inputEmail" placeholder="Email" path="email" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="control-label col-xs-2">Hostname</label>
                <div class="col-xs-10">
                    <ff:input type="text" class="form-control" id="inputPassword" placeholder="Hostname" path="name" readonly="readonly" />
                </div>
            </div>
            
            <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-2">Address ->> City</label>
                <div class="col-xs-10">
                    <ff:input type="text" class="form-control" id="inputEmail" placeholder="Address" path="address.city" readonly="readonly"/>
                </div>
            </div>
            
            <div class="form-group">
                <label for="inputPassword" class="control-label col-xs-2">Address ->> pincode</label>
                <div class="col-xs-10">
                    <input type="text" class="form-control" id="inputPassword" placeholder="City" name="address.pincode" readonly="readonly" value="${ccustomer.address.pincode}"/>
                </div>
            </div>
            
            
             <div class="form-group">
                <label for="inputPassword" class="control-label col-xs-2">Address ->> Phone->>mobile1</label>
                <div class="col-xs-10">
                    <ff:input type="text" class="form-control" id="inputPassword" placeholder="City" path="address.phone.mobile1" readonly="readonly"/>
                </div>
            </div>
            
            
             <div class="form-group">
                <label for="inputPassword" class="control-label col-xs-2">Address ->> Phone->>mobile2</label>
                <div class="col-xs-10">
                    <ff:input type="text" class="form-control" id="inputPassword" placeholder="City" path="address.phone.mobile2" readonly="readonly"/>
                </div>
            </div>
            
            
            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-primary">Sync</button>
                </div>
            </div>
 </ff:form>
</div>
   
</fieldset>
<hr style="color:red;"/>
</body>
</html>                                		