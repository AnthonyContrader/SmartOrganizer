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
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist">Tools</a>
  <a class="active" href="LocationServlet?mode=locationlist">Locations</a>
  <a class="active" href="WorkgroupServlet?mode=workgrouplist">Workgroups</a>
  <a class="active" href="CalendarServlet?mode=calendarlist">Calendar</a>
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
		<th></th>
		<th></th>
	</tr>
	<%
		for(CalendarDTO c : list){
	%>
	<tr>
		<td><a href=CalendarServlet?mode=read&idcalendar=<%=c.getIdcalendar()%>><%=c.getDate().toString()%></a></td>
		<td><%=c.getCheckin() %></td>
		<td><%=c.getCheckout() %></td>
		<td><%=c.getEmployee() %></td>
		<td><a href=CalendarServlet?mode=read&update=true&idcalendar=<%=c.getIdcalendar() %>>Edit</a></td>
		<td><a href=CalendarServlet?mode=delete&idcalendar=<%=c.getIdcalendar() %>>Delete</a></td>
	</tr>
	<%
		}
	%>
	</table>
	
<form id="floatright" action="CalendarServlet?mode=insert" method="post">
	<div class="row">
		<div class="col-25">
			<label for="data">Date</label>
		</div>
		<div class="col-75">
			<input type="date" id="data" name="date" min="2019-12-01">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="checkin">Checkin</label>
		</div>
		<div class="col-75">
			<input type="text" id="checkin" name="checkin" placeholder="inserisci l'ora del checkin">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="checkout">Checkout</label>
		</div>
		<div class="col-75">
			<input type="text" id="checkout" name="checkout" placeholder="inserisci l'ora del checkout">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="employee">Employee</label>
		</div>
		<div class="col-75">
			<input type="text" id="employee" name="employee" placeholder="inserisci il nome del dipendente">
		</div>
	</div>
	<button type="submit">Insert</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp"%>
</body>
</html>