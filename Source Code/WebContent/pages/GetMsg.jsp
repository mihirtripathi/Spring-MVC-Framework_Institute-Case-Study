<%@page import="com.keane.training.domain.Msg" %>
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
<title>Messages</title>
</head>
<body>
<h3> Notifications/Messages to Institutes by Admin</h3>
<table border="2">
<tr><td> Institute Name </td>  <td> Messages </td>     </tr>

<%List msglist = (List)request.getAttribute("msglist"); %>

 

<%
  
  Iterator iterator = msglist.iterator();  
  
  while(iterator.hasNext())  // iterate through all the data until the last record
  {
	Msg msg ;
	msg= (Msg)iterator.next(); //assign individual employee record to the employee class object
  %>

<tr><td><%=msg.getIname()%></td>	<td><%=msg.getMsg()%></td>

</tr>
<% } %>

 </table>

</body>
</html>