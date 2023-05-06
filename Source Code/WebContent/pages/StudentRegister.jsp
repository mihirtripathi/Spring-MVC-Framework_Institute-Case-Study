<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
<h1 align="center">Student Registration</h1>
</nav>
<form action="RegisterStudent.do">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td>Choose Your Student ID</td>
		<td><input type="number" name="stud_id" pattern="[7-9]{1}[0-9]{9}" placeholder="Choose Unique ID" required="required"></td>
	</tr>
	<tr>
		<td>Student Name</td>
		<td><input type="text" name="sname" placeholder="Enter the name" pattern="([^\s][a-zA-Z\s]+)" required="required"></td>
	</tr>
	<tr>
		<td>Qualification</td>
		<td><input type="text" name="squalification" placeholder="Highest qualification" required="required"></td>
	</tr>
	<tr>
		<td>Contact Number</td>
		<td><input type="text" name="scontact" pattern="[7-9]{1}[0-9]{9}" placeholder="Enter the Mobile Number" required="required"></td>
	</tr><tr>
		<td>Address</td>
		<td><input type="text" name="saddress" required="required"></td>
	</tr>
	<tr>
		<td>Email ID</td>
		<td><input type="email" name="email" placeholder="abc@gmail.com" required="required"></td>
	</tr>
	
	
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="Register"></td>
	</tr>
</table>
</form>
</body>
</html>