<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Registration</title>
<link rel="StyleSheet" href="stylereg.css">
</head>
<body>
<div id=head>
<h2>Patient Registration Form</h2>
</div>
<center>
<table>

<tr><td><h3>Basic Information</h3></td></tr>

<form action="RegistrationManager" method="post" enctype="multipart/form-data">
<tr><td>Patient Name</td><td><input type="text" name="pname" required="required"></td></tr>
<tr><td>Address</td><td><input type="text" name="address"></td></tr>
<tr><td>Gender</td>
<td><input type="radio" name = "gender" value="Male" required="required">Male
<input type="radio" name = "gender" value="Female" required="required">Female
<input type="radio" name = "gender" value="Others" required="required">Others</td></tr>
<tr><td>Medical Records</td><td><input type="file" name="records"></td></tr>
<tr><td>Contact No</td><td><input type="tel" pattern="[0-9]{10}" name="contact" required="required"/></td></tr>
</table>
<br>
<br>
<input type="submit" value="Register" id="reg"/>
</center>

</form>
</body>
</html>