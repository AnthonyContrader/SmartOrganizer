<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CalendarDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Calendar</title>
</head>
<body>
<%@include file="../css/header.jsp" %>

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
<br>
<div class="main">
<% CalendarDTO c = (CalendarDTO) request.getAttribute("dto"); %>
<form id="floatleft" action="CalendarServlet?mode=update&idcalendar=<%=c.getIdcalendar() %>" method="post">
	<div class="row">
		<div class="col-25">
			<label for="date">Date</label>
		</div>
		<div class="col-75">
			<input type="date" id="date" name="date" value=<%=c.getDate() %>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="checkin">Checkin</label>
		</div>
		<div class="col-75">
			<input type="text" id="checkin" name="checkin" value=<%=c.getCheckin() %>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="checkout">Checkout</label>
		</div>
		<div class="col-75">
			<input type="text" id="checkout" name="checkout" value=<%=c.getCheckout() %>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="employee">Employee</label>
		</div>
		<div class="col-75">
			<input type="text" id="employee" name="employee" value=<%=c.getEmployee()%>>
		</div>
	</div>
	<button type="submit">Insert</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>