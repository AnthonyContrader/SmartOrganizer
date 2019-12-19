<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CalendarDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Calendar</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist">Tools</a>
  <a class="active" href="LocationServlet?mode=locationlist">Locations</a>
  <a class="active" href="WorkgroupServlet?mode=workgrouplist">Workgroups</a>
  <a class="active" href="CalendarServlet?mode=calendarlist">Calendar</a>
  <a  href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%CalendarDTO c = (CalendarDTO) request.getAttribute("dto"); %>
<table>
	<tr>
		<th>Date</th>
		<th>Checkin</th>
		<th>Checkout</th>
		<th>Employee</th>
	</tr>
	<tr>
		<td><%=c.getDate().toString() %></td>
		<td><%=c.getCheckin() %></td>
		<td><%=c.getCheckout() %></td>
		<td><%=c.getEmployee() %></td>
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
<br>
</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>