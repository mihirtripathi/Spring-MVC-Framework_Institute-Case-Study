<%@page import="com.keane.training.domain.Resp" %>
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
<title>Responses</title>
</head>
<body>
<h3> Responses by Requested Institutes</h3>
<table border="2">
<tr><td>Student ID</td>   <td> Institute Name </td>  <td> Responses </td>     </tr>

<%List resplist = (List)request.getAttribute("resplist"); %>

 

<%
  
  Iterator iterator = resplist.iterator();  
  
  while(iterator.hasNext())  // iterate through all the data until the last record
  {
	Resp resp ;
	resp= (Resp)iterator.next(); //assign individual employee record to the employee class object
  %>

<tr><td><%=resp.getStud_id()%></td>  <td><%=resp.getIname()%></td>	<td><%=resp.getResp()%></td>

</tr>
<% } %>

 </table>

</body>
</html>