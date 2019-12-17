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
  <a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%EmployeesDTO e = (EmployeesDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Surname</th>
		<th>Fiscalcode</th>
		<th>Worksector</th>
		<th>Position</th>
		<th>Numberofregistration</th>
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