<%@page import="com.keane.training.domain.Feedback" %>
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
<title>Feedbacks</title>
</head>
<body>
<h3> Feedbacks</h3>
<table border="2">
<tr><td> Institute Name </td>   <td> Feedback  </td>    <td>Student ID</td>   </tr>

<%List feedbacklist = (List)request.getAttribute("feedbacklist"); %>

 

<%
  
  Iterator iterator = feedbacklist.iterator();  
  
  while(iterator.hasNext())  // iterate through all the data until the last record
  {
	Feedback feedback ;
	feedback= (Feedback)iterator.next(); //assign individual employee record to the employee class object
  %>

<tr><td><%=feedback.getIname()%></td>  <td><%=feedback.getFeedback()%></td>	<td><%=feedback.getStud_id()%></td>

</tr>
<% } %>

 </table>

</body>
</html>