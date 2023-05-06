<%@page import="com.keane.training.domain.Student" %>
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
<title>Student Details</title>
</head>
<body>
<h3> Student Details</h3>
<table border="2">
<tr><td> Student ID </td>   <td> Password  </td><td> Name  </td>   <td> Qualification </td>   <td>  Contact   </td>    <td> Address</td>   <td> Email </td>  </tr>

<%List studentlist = (List)request.getAttribute("studentlist"); %>

 

<%
  
  Iterator iterator = studentlist.iterator();  
  
  while(iterator.hasNext())  // iterate through all the data until the last record
  {
    Student student ;
    student= (Student)iterator.next(); //assign individual employee record to the employee class object
  %>

<tr><td><%=student.getStud_id()%></td>  <td><%=student.getSpassword()%></td>   <td><%=student.getSname()%></td>   <td><%=student.getSqualification()%></td>
<td><%=student.getScontact()%></td> <td><%=student.getSaddress()%></td>  <td><%=student.getEmail()%></td>           

</tr>
<% } %>

 </table>

</body>
</html>
