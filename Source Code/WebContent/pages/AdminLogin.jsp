<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
<h2 align="center">Admin Login</h2>
</nav>
<form action="AdminLogin.do">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td>Username :</td>
		<td><input type="text" name="userid" placeholder="Type Here" required="required" ></td>
	</tr>
	<tr>
		<td>password :</td>
		<td><input type="password" name="password" required="required" ></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>



</body>
</html>