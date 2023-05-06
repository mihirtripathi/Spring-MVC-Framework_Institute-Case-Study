<%@page import="com.keane.training.domain.Req" %>
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
<title>Requests</title>
</head>
<body>
<h3> Requests by Students</h3>
<table border="2">
<tr><td> Institute Name </td> <td>Student ID</td>    <td> Requests  </td>     </tr>

<%List reqlist = (List)request.getAttribute("reqlist"); %>

 

<%
  
  Iterator iterator = reqlist.iterator();  
  
  while(iterator.hasNext())  // iterate through all the data until the last record
  {
	Req req ;
	req= (Req)iterator.next(); //assign individual employee record to the employee class object
  %>

<tr><td><%=req.getIname()%></td>	<td><%=req.getStud_id()%></td>  <td><%=req.getReq()%></td>

</tr>
<% } %>

 </table>

</body>
</html>