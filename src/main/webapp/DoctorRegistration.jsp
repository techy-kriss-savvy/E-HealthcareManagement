<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Registration</title>
<link rel="StyleSheet" href="stylereg.css">
</head>
<body>
<div id="head">
<h2>Doctor Registration Form</h2>
</div>
<center>
<div id="body">
<table>

<tr><td><h3>Basic Information</h3></td></tr>

<form action="DocRegistrationManager" method="post" enctype="multipart/form-data">
<tr><td>Doctor Name</td><td><input type="text" name="dname" required="required"></td></tr>
<tr><td>Address</td><td><input type="text" name="address"></td></tr>
<tr><td>Gender</td>
<td><input type="radio" name = "gender" value="Male" required="required">Male
<input type="radio" name = "gender" value="Female" required="required">Female
<input type="radio" name = "gender" value="Others" required="required">Others</td></tr>
<tr><td>Doctor License</td><td><input type="file" name="license" required="required" ></td></tr>
<tr><td><h3>Specialised In</h3></td>
<td><select required="required" name="specialisation" id="spec"><option>--Select-your-Specialisation--</option>
<option>General Physician</option>
<option>Gynecologist</option>
<option>Otolaryngologist</option>
<option>Proctologist</option></select></td></tr>
<tr><td>Profile Photo</td><td><input type="file" name="profile" required="required"></td></tr>
<tr><td>Contact No</td><td><input type="tel" pattern="[0-9]{10}" name="contact" required="required"/></td></tr>
</table>
</div>
<br>
<br>
<input type="submit" value="Register" id="reg"/>
</center>
</form>
</body>
</html>