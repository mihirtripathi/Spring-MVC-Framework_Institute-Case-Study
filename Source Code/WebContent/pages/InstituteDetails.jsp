<%@page import="com.keane.training.domain.Institute" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Institute Details</title>
</head>
<body>
<h3> Institute Details</h3>
<table border="2">
<tr><td> Institute Name </td>   <td> Password  </td> <td>Institute Address</td>  <td>Total Number of Seats</td>  <td>Total Number of Courses</td>  <td>Total Number of Faculties</td>   </tr>

<%List institutelist = (List)request.getAttribute("institutelist"); %>

 

<%
  
  Iterator iterator = institutelist.iterator();  
  
  while(iterator.hasNext())  // iterate through all the data until the last record
  {
    Institute institute ;
    institute= (Institute)iterator.next(); //assign individual employee record to the employee class object
  %>

<tr><td><%=institute.getIname()%></td>  <td><%=institute.getIpassword()%></td>	<td><%=institute.getIaddress()%></td>
<td><%=institute.getNseats()%></td>   <td><%=institute.getNcourses()%></td>     <td><%=institute.getNfaculty() %></td>      

</tr>
<% } %>

 </table>

</body>
</html>