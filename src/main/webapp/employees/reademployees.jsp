<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EmployeesDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Employees</title>
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
  <a class="active" href="BillServlet?mode=billlist">Bills</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%EmployeesDTO e = (EmployeesDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Surname</th>
		<th>FiscalCode</th>
		<th>WorkSector</th>
		<th>Position</th>
		<th>NumberOfRegistration</th>
	</tr>
	<tr>
		<td><%=e.getName()%></td>
		<td> <%=e.getSurname()%></td>
		<td> <%=e.getFiscalcode()%></td>
		<td> <%=e.getWorksector()%></td>
		<td> <%=e.getPosition()%></td>
		<td> <%=e.getNumberofregistration()%></td>
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

<%@ include file="../css/footer.jsp" %>
</body>
</html>