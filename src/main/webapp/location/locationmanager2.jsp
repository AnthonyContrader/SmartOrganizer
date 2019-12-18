<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.LocationDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Location Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
<a  href="homeuser.jsp">Home</a>
<a class="active" href="UserServlet?mode=userlist&usermode=true">Users</a>
<a class="active" href="EmployeesServlet?mode=employeeslist&usermode=true">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist&usermode=true">Tools</a>
<a class="active" href="LocationServlet?mode=locationlist&usermode=true">Locations</a>
<a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
<% List<LocationDTO> list = (List<LocationDTO>) request.getAttribute("list");%>
<br>

<table>
<tr>
<th>Address</th>
<th>City</th>
<th>Typeoflocation</th>
<th>worktype</th>
</tr>
<% for(LocationDTO l : list) { %>
<tr>
<td><%=l.getAddress() %></td>
<td><%=l.getCity() %></td>
<td><%=l.getTypeoflocation() %></td>
<td><%=l.getWorktype() %></td>
</td>



</tr>

<%} %>

</table>

</div>

<br>
<%@ include file="../css/footer.jsp" %>



</body>
</html>