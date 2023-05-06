<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Complain</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
<h1 align="center">Complain</h1>
</nav>
<form action="GiveComplain.do">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td>Your Student ID</td>
		<td><input type="number" name="stud_id"></td>
	</tr>
	<tr>
		<td>Institute Name</td>
		<td><input type="text" name="iname"></td>
	</tr>
	<tr>
		<td>Complaint</td>
		<td><input type="text" name="complain"></td>
	</tr>
	
	
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="Register"></td>
	</tr>
</table>
</form>
</body>
</html>