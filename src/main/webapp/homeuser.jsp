<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
   <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist">Tools</a>
  <a class="active" href="LocationServlet?mode=locationlist">Locations</a>
  <a class="active" href="WorkgroupServlet?mode=workgrouplist">Workgroups</a>
  <a class="active" href="CalendarServlet?mode=calendarlist">Calendar</a>
  <a class="active" href="BillServlet?mode=billlist">Bills</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
<h1>Welcome ${user.getUsername()}</h1>
<br>
"Software for the management of construction activities, managing the resources, employees, the workplace and the equipment that the workers will use"
"Software for the management of construction activities, managing the resources, employees, the workplace and the equipment that the workers will use"
"Software for the management of construction activities, managing the resources, employees, the workplace and the equipment that the workers will use"
"Software for the management of construction activities, managing the resources, employees, the workplace and the equipment that the workers will use"
"Software for the management of construction activities, managing the resources, employees, the workplace and the equipment that the workers will use"
"Software for the management of construction activities, managing the resources, employees, the workplace and the equipment that the workers will use"
"Software for the management of construction activities, managing the resources, employees, the workplace and the equipment that the workers will use"
"Software for the management of construction activities, managing the resources, employees, the workplace and the equipment that the workers will use"

</div>


<%@ include file="css/footer.jsp" %>
</body>
</html>