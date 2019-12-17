<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.LocationDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Location</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
 <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist">Tools</a>
  <a class="active" href="LocationServlet?mode=location">Locations</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">
<%LocationDTO l = (LocationDTO) request.getAttribute("dto");%>

<table>
<tr>
<th>address</th>
<th>city</th>
<th>typeoflocation</th>
<th>worktype</th>
</tr>
<tr>
<td><%=l.getAddress() %></td>
<td><%=l.getCity() %></td>
<td><%=l.getTypeoflocation() %></td>
<td><%=l.getWorktype() %></td>

</tr>
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>

<%@include file="../css/footer.jsp" %>
</body>
</html>