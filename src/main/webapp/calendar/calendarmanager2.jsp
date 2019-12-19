<%@page import="it.contrader.model.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.CalendarDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Calendar Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeuser.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist&usermode=true">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist&usermode=true">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist&usermode=true">Tools</a>
  <a class="active" href="LocationServlet?mode=locationlist&usermode=true">Locations</a>
  <a class="active" href="WorkgroupServlet?mode=workgrouplist&usermode=true">Workgroups</a>
  <a class="active" href="CalendarServlet?mode=calendarlist&usermode=true">Calendar</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
<%
List<CalendarDTO> list = (List<CalendarDTO>) request.getAttribute("list");
%>
<br>
	<table>
	<tr>
		<th>Date</th>
		<th>Checkin</th>
		<th>Checkout</th>
		<th>Employee</th>
	</tr>
	<%
		for(CalendarDTO c : list){
	%>
	<tr>
		<td><%=c.getDate().toString()%></td>
		<td><%=c.getCheckin() %></td>
		<td><%=c.getCheckout() %></td>
		<td><%=c.getEmployee() %></td>
		
	</tr>
	<%
		}
	%>
	</table>
</div>
<br>
<%@ include file="../css/footer.jsp"%>
</body>
</html>