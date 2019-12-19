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
  <a class="active" href="homeuser.jsp">Home</a>
  <a href="UserServlet?mode=userlist&usermode=true">Users</a>
  <a href="EmployeesServlet?mode=employeeslist&usermode=true">Employees</a>
  <a href="ToolServlet?mode=toollist&usermode=true">Tools</a>
  <a href="LocationServlet?mode=locationlist&usermode=true">Locations</a>
  <a href="WorkgroupServlet?mode=workgrouplist&usermode=true">Workgroups</a>
  <a href="CalendarServlet?mode=calendarlist&usermode=true">Calendar</a>
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