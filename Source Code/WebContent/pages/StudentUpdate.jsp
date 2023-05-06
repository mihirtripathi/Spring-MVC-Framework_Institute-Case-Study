<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Details</title>
</head>
<body>
<h2>Enter the Details to Update for Student</h2>
  <form action="StudentUpdate.do">
    <div class="form-group">
      <label for="stud_id">Student ID :</label>
      <input type="number" class="form-control" id="stud_id" placeholder="Enter Student ID" name="stud_id">
    </div>
    <div class="form-group">
      <label for="email">New Email ID :</label>
      <input type="email" class="form-control" id="email" placeholder="Enter Updated Email" name="email">
    </div>
    
    <button type="submit" class="btn btn-primary">Update</button>
  </form>
</div>
<br>
<br>
<br>
<a href="home.jsp">Go Back to Homepage</a>
</body>
</html>