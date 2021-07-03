<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<title>Update Employee Details</title>
	
</head>

<body>
<div align="center" style="margin-top:20px;width:600px; margin-left:350px">

	<div id ="header" style="width:100% ; background-color: aliceblue ; margin-bottom:20px">
		<table width="100%">
			<tr>				
				<td align = "right">
					<table>
					<tr>
						<td>
							<h3>Welcome ${userName} !</h3>
						</td>
						<td>
							<form action="back">
								&nbsp;&nbsp;<input class="btn btn-primary" type = "submit" value = "Back"/>
							</form>
						</td>
						<td>
							<form action="logout">
								&nbsp;&nbsp;<input class="btn btn-primary" type = "submit" value = "LogOut"/>
							</form>
						</td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
	<div>
	<fieldset style="padding:30px; border : 3px solid lightskyblue; border-radius:10px">
	<legend  style="color:black; width:300px; background:lightskyblue; padding:10px; border-radius:10px; font-size:20px; font-weight:bold;">Edit Employee Details</legend>
	
	<div>
		<form action="delete" >
			<input type="text" name="employeecode" id="employeecode" value="${Employee.getEmployeeCode()}" hidden/>
			<input  style="margin-bottom:20px;" class="btn btn-primary"  type="submit" value="Delete Employee Details" />
		</form>
	</div>
	
	<div>
		<form  action="updateEmployee" method="post" name="form" >	
	   		<table cellpadding="10" style="background-color: aliceblue;">
		 
		 		<tr>
					<td style="width: 200px; padding: 10px; font-weight:bold;">Employee Code :</td>
					<td>
					<input type="text" name="empcode" id="empcode"  value="${Employee.getEmployeeCode()}" readonly="readonly"/>
					</td>
				 </tr>
				 <tr>
					<td style="width: 200px; padding: 10px; font-weight:bold;">Employee Name :</td>
					<td>
					<input type="text" name="empname" id="empname" value="${Employee.getEmployeeName()}" maxlength = "100" required/>
					</td>
				 </tr>
				 <tr>
					<td style="width: 200px; padding: 10px;font-weight:bold;">Employee Location :</td>
					<td> 
					<input type="text" name="emplocation" id="emplocation" value="${Employee.getEmployeeLocation()}" maxlength = "500" required />
					</td>
				 </tr>
				 <tr>
					<td style="width: 200px; padding: 10px;font-weight:bold;">Employee Email :</td>
					<td> 
					<input type="email" name="empemail" id="empemail" value="${Employee.getEmployeeEmail()}" maxlength = "100" required />
					</td>
				 </tr>
				 <tr>
					<td style="width: 200px; padding: 10px;font-weight:bold;">Employee DOB :</td>
					<td> 
					<input type="text" style="width: 187px;" name="empdob" id="empdob" value="${Employee.getEmployeeDob()}" required/>
					</td>
				 </tr>
		    	 <tr>
					<td align="right" style="width: 200px; padding: 10px;">
					<input type="submit" class="btn btn-primary"  value="Update>>" />
					</td>
					<td> 
					<input type="reset" class="btn btn-primary"  value="Cancel" />
					</td>
				 </tr>		
			 
	 		</table>	  
  		</form>
	</div>
	
	</fieldset>	
	</div>
	
</div>
</body>

</html>