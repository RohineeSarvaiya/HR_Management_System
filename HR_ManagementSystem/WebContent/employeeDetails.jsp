<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Model.Employee" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
	
	<title>Employee Details</title>
	
</head>

<body>
<div align = "center" class = "container" style=" margin-top:20px;" >

	<div id ="header" style="width:100% ; background-color: aliceblue ; margin-bottom:20px">
		<table width="100%">
			<tr>
				<td></td>
				<td align = "right">
					<table>
					<tr>
						<td>
							<h3>Welcome ${userName} !</h3>
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
	<legend  style="color:black; width:250px; background:lightskyblue; padding:10px; border-radius:10px; font-size:20px; font-weight:bold;">Employee Listings</legend>
	
	<div>
		<table width="100%">
			<tr>
				<td></td>
				<td align = "right">
					<table>
					<tr>
						<td>
							<form action="upload">
								<input class="btn btn-primary" type = "submit" value = "Upload Employee Details"/>
							</form>
						</td>
						<td>
							<form action="download" >
								&nbsp;<input class="btn btn-primary" type = "submit" value = "Download Employee Details"/>
							</form>
						</td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
	<div>
		<table  class = "table table-bordered" style="table-layout:fixed; text-align:center;background-color: aliceblue;margin-top:20px">
			
			<tr style="background-color: #87CEEB;">
				<th> Employee Code</th>
				<th> Employee Name </th>
				<th> Location </th>
				<th> Email </th>
				<th> Date Of Birth </th>
				<th> Action </th>
			</tr>
			
			<c:forEach items = "${employees}" var="e">
			<tr>
				<td style="word-break: break-all;">${e.getEmployeeCode()}</td>
				<td style="word-break: break-all;">${e.getEmployeeName()}</td>
				<td style="word-break: break-all;">${e.getEmployeeLocation()}</td>
				<td style="word-break: break-all;">${e.getEmployeeEmail()}</td>
				<td style="word-break: break-all;">${e.getEmployeeDob()}</td>
				<td>
				  <form action="update" >
					<input type="text" name="employeecode" id="employeecode" value="${e.getEmployeeCode()}" hidden/>
					<input class="btn btn-primary"  type="submit" value="Edit" />
				  </form>
				</td>
			</tr>
  			</c:forEach>			
			
		</table>
	</div>
	
	</fieldset>
	</div>

</div>	
</body>

</html>

