	<!DOCTYPE html>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login to Our Website</title>
<meta name="description" content="" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script>
	
jQuery(function($){
		   
	// simple jQuery validation script
	$('#login').submit(function(){
		
		var valid = true;
		var errormsg = 'This field is required!';
		var errorcn = 'error';
		
		$('.' + errorcn, this).remove();			
		
		$('.required', this).each(function(){
			var parent = $(this).parent();
			if( $(this).val() == '' ){
				var msg = $(this).attr('title');
				msg = (msg != '') ? msg : errormsg;
				$('<span class="'+ errorcn +'">'+ msg +'</span>')
					.appendTo(parent)
					.fadeIn('fast')
					.click(function(){ $(this).remove(); })
				valid = false;
			};
		});
		
		return valid;
	});
	
})	



</script>
<style>


/* //  HTML elements */	

/* base */

body, table, input, textarea, select, li, button{
	font:1em "Lucida Sans Unicode", "Lucida Grande", sans-serif;
	line-height:1.5em;
	color:#444;
	}	
body{
	font-size:12px;
	background:white;		
	text-align:center;
	}		


table.myclass td {
    margin: 18px 18px 18px 18px;
}​

/* //  login form */	
		
</style>


</head>
<body>

 <a href="${pageContext.request.contextPath}/mobile/logout">Logout<img src="${pageContext.request.contextPath}/img/logout.png"></a>
 <section style="height: 30px;background-color: pink;">
 
 </section>
	  <img src="${pageContext.request.contextPath}/img/pic2.jpg"/> User Profile Page
	  <br/>
	  <span style="color:blue;font-size: 14px;">${requestScope.ApplicationMessage}</span>
	  
	  <center>
	  <table style="width: 70%;border-width:2px;" border="1" class="myclass" >
	  		<tr style="background-color:yellow;">
	  				<td>Sno</td>
	  				<td>Username
	  				<a href="${pageContext.request.contextPath}/mobile/sortByUsernameAsc"><img src="${pageContext.request.contextPath}/img/sort-ascend.png"></a>
	  				
	  				</td>
	  				<td>Role</td>
	  				<td>Company Name</td>
	  				<td>Email <img src="${pageContext.request.contextPath}/img/sort-ascend.png"></td>
	  				<td>City</td>
	  				<td>Titile</td>
	  				<td>Photo</td>
	  				<td>Action</td>
	  		</tr>
	  		<c:forEach items="${userProfiles}" var="item" varStatus="aha">
	  		<tr style="background-color:white;">
	  				<td>${aha.count}</td>
	  				<td>${item.username}</td>
	  				<td>${item.role}</td>
	  			<td>${item.companyName}</td>
	  			<td>${item.email}</td>
	  				<td>${item.city}</td>
	  					<td>${item.title}</td>
	  				<td> <img src="${pageContext.request.contextPath}/mobile/findImageByUsername?username=${item.username}"  height="40px;"/></td>
	  				<td><a href="${pageContext.request.contextPath}/mobile/deleteUserProfile?uid=${item.sno}"><img src="${pageContext.request.contextPath}/img/delete.png"></a>
	  				    &nbsp;
	  				    <a href="${pageContext.request.contextPath}/mobile/editProfile?uid=${item.sno}"><img src="${pageContext.request.contextPath}/img/edit.png"></a> 
	  					</td>
	  		</tr>
	  		</c:forEach>
	  	
	  		
	  		<tr style="background-color:white;">
	  				<td>1</td>
	  				<td>Nagendra Kumar</td>
	  				<td>Admin</td>
	  				<td>TCS Ltd</td>
	  				<td>nagen@gmail.com</td>
	  				<td>Noida</td>
	  				<td>Software Consultant</td>
	  				<td>TODO</td>
	  				<td><a href="#"><img src="${pageContext.request.contextPath}/img/delete.png"></a>	</td>
	  		</tr>
	  
	  </table>
	  <a href="${pageContext.request.contextPath}/mobile/kill">Not Accessible Page</a>
    </center>

</body>
</html>
