<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<title>SignUp</title>
	
</head>

<body>
<div align="center" style="margin-top:120px;width:600px; margin-left:350px">

	<fieldset style="padding:30px; border : 3px solid lightskyblue; border-radius:10px">
	<legend  style="color:black; width:100px; background:lightskyblue; padding:10px; border-radius:10px; font-size:20px; font-weight:bold;">SignUp</legend>
	
	<form  name="form"  action="signup" method="post" onsubmit="return InputValidation();">
		
		<table cellpadding="10">	
		 
		 <tr>
			<td style="background-color: aliceblue;">
				<table>
					 <tr>
						<td style="width: 200px; padding: 10px;font-weight:bold;">Username :</td>
						<td><h3 style="color: red; display: inline;">*</h3> 
						<input type="text" name="username" id="username" />
						</td>
					 </tr>
					 <tr>
						<td style="width: 200px; padding: 10px;font-weight:bold;">Password :</td>
						<td><h3 style="color: red; display: inline;">*</h3> 
						<input type="password" name="password" id="password" />
						</td>
					 </tr>
					 <tr>
						<td style="width: 200px; padding: 10px;font-weight:bold;">Confirm Password :</td>
						<td><h3 style="color: red; display: inline;">*</h3> 
						<input type="text" name="cpassword" id="cpassword" />
						</td>
					 </tr>					 
				 </table>
			 </td>
		 </tr>
		 
		 <tr>
			<td style="text-align:right; margin-right: 10px; background-color: aliceblue; border-style: solid; border-top-color: lightskyblue; border-bottom-color: lightskyblue; border-left-color: aliceblue; border-right-color: aliceblue;">
			<input type="submit" class="btn btn-primary"  value="SignUp>>" />
			</td>
		 </tr>
		 
	 	 </table>
	 
	 </form>
	 </fieldset>
	 
</div>
</body>

<script>
	function InputValidation(){
		var uname = document.form.username.value;
		var pass = document.form.password.value;
		var cpass = document.form.cpassword.value;
		if (uname == "")
		{
			alert ( "Please enter User Name." );
			document.form.username.focus();
			return false;
		}
		if (pass == "")
		{
			alert ( "Please enter password." );
			document.form.password.focus();
			return false;
		}
		if (cpass == "")
		{
			alert ( "Please confirm password." );
			document.form.cpassword.focus();
			return false;
		}
		if(uname.length<5 || uname.length>50)
		{
			alert ( "Username length must be between 5 to 50 characters." );
			document.form.username.focus();
			return false;
		}
		if (pass.length<5 || pass.length>50)
		{
			alert ( "Password length must be between 5 to 50 characters."  );
			document.form.password.focus();
			return false;
		}
		if(document.getElementById("password").value!=document.getElementById("cpassword").value)
		{
			alert ( "Password and Confirm password must be Equal." );
			document.form.password.focus();
			document.form.cpassword.focus();
			return false;
		}
		return true;
	}
</script>

</html>