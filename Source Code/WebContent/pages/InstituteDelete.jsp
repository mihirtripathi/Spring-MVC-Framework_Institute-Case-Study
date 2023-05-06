<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Institute</title>
</head>
<body>
<h2>Enter the Name of Institute to Delete</h2>
  <form action="InstituteDelete.do">
    <div class="form-group">
      <label for="iname">Institute Name :</label>
      <input type="text" class="form-control" id="iname" placeholder="Type Institute Name" name="iname">
    </div>
    
    <button type="submit" class="btn btn-primary">Delete</button>
  </form>
</div>
<br>
<br>
<br>
<a href="home.jsp">Go Back to Homepage</a>
</body>
</html>