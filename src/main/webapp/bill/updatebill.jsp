<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.BillDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Bill</title>
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
  <a class="active" href="BillServlet?mode=billList">Bills</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">
<%BillDTO b = (BillDTO) request.getAttribute("dto"); %>
<form id ="floatleft" action="BillServlet?mode=update&idbill=<%=b.getIdbill() %>" method="post">
	<div class="row">
		<div class="col-25">
			<label for="numberbill">numberbill</label>
		</div>
		<div class="col-75">
			<input type="text" id="numberbill" name="numberbill" value=<%=b.getNumberbill() %>> 
		</div>
	</div>
		<div class="row">
		<div class="col-25">
			<label for="date">date</label>
		</div>
		<div class="col-75">
			<input type="date" id="date" name="date" value=<%=b.getDate() %>> 
		</div>
	</div>
		<div class="row">
		<div class="col-25">
			<label for="customer">customer</label>
		</div>
		<div class="col-75">
			<input type="text" id="customer" name="customer" value=<%=b.getCustomer() %>> 
		</div>
	</div>
		<div class="row">
		<div class="col-25">
			<label for="price">price</label>
		</div>
		<div class="col-75">
			<input type="text" id="price" name="price" value=<%=b.getPrice() %>> 
		</div>
	</div>
		<div class="row">
		<div class="col-25">
			<label for="location">location</label>
		</div>
		<div class="col-75">
			<input type="text" id="location" name="location" value=<%=b.getLocation() %>> 
		</div>
	</div>
		<button type="submit">Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>