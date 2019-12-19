<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.LocationDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Location</title>
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
<br>
<div class="main">

<%LocationDTO l = (LocationDTO) request.getAttribute("dto"); %>

<form id="floatleft" action="LocationServlet?mode=update&idlocation=<%=l.getIdlocation() %>"method="post">
<div class="row">
<div class="col-25">
<label for="adress">Address</label>
</div>
<div class=col-75>
<input type="text" id="address" name="address" value=<%=l.getAddress() %>>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="city">City</label>
</div>
<div class=col-75>
<input type="text" id="city" name="city" value=<%=l.getCity() %>>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="typeoflocation">Typeoflocation</label>
</div>
<div class=col-75>
<input type="text" id="typeoflocation" name="typeoflocation" value=<%=l.getTypeoflocation() %>>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="worktype">worktype</label>
</div>
<div class=col-75>
<input type="text" id="worktype" name="worktype" value=<%=l.getWorktype() %>>
</div>
</div>
<button type="submit" >Edit</button>
</form>
</div>
</body>
</html>