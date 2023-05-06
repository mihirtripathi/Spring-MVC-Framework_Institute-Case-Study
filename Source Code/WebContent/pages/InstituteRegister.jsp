<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register yourself</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
<h1 align="center">Institute Registration</h1>
</nav>
<form action="RegisterInstitute.do">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td>Insitute Name</td>
		<td><input type="text" name="iname" placeholder="Enter the name" pattern="([^\s][a-zA-Z\s]+)" required="required"></td>
	</tr>
	<tr>
		<td>Set Password</td>
		<td><input type="password" name="ipassword" placeholder="Try Strong Password" pattern="([^\s][a-zA-Z\s]+)" required="required"></td>
	</tr>
	<tr>
		<td>Institute Address</td>
		<td><input type="text" name="iaddress" required="required"></td>
	</tr>
	<tr>
		<td>Total Number of Seats</td>
		<td><input type="number" name="nseats" required="required"></td>
	</tr>
	<tr>
		<td>Total Number of Courses</td>
		<td><input type="number" name="ncourses" required="required"></td>
	</tr>
	<tr>
		<td>Total Number of Faculties</td>
		<td><input type="number" name="nfaculty" required="required"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="Register"></td>
	</tr>
</table>
</form>
</body>
</html>