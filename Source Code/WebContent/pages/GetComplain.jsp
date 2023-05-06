<%@page import="com.keane.training.domain.Complain" %>
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
<title>Complaints</title>
</head>
<body>
<h3> Complaints</h3>
<table border="2">
<tr><td> Student ID </td>   <td> Institute Name  </td>    <td>Complaint</td>   </tr>

<%List complainlist = (List)request.getAttribute("complainlist"); %>

 

<%
  
  Iterator iterator = complainlist.iterator();  
  
  while(iterator.hasNext())  // iterate through all the data until the last record
  {
	  Complain complain ;
	  complain= (Complain)iterator.next(); //assign individual employee record to the employee class object
  %>

<tr><td><%=complain.getStud_id()%></td>		<td><%=complain.getIname()%></td> 	 <td><%=complain.getComplain()%></td>	

</tr>
<% } %>

 </table>

</body>
</html>