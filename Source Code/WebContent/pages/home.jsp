<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Admin</title>
</head>
<body>
Successfully Logged in
<br>
<br>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
<h1>WELCOME ADMIN</h1>
</nav>
<h3>Choose Functions</h3>
<a href="StudentDetails.do">View Students Data</a>
<br>
<a href="InstituteDetails.do">View Institutes Data</a>
<br>
<a href="GetComplain.do">View Complaints by Students</a>
<br>
<a href="GiveMsg.jsp">Send Notification to Institute</a>
<br>
<a href="StudentUpdate.jsp">Update Students Details</a>
<br>
<a href="InstituteDelete.jsp">Delete Institute</a>
<br>
<br>
<br>
<br>
<a href="index.jsp"><button type="submit" class="btn btn-success">	LOGOUT</button></a>
</body>
</html>