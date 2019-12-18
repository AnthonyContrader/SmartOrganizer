<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EmployeesDTO"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Employees Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeuser.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist&usermode=true">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist&usermode=true">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist&usermode=true">Tools</a>
  <a class="active" href="LocationServlet?mode=locationlist&usermode=true">Locations</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<EmployeesDTO> list = (List<EmployeesDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Fiscalcode</th>
			<th>Worksector</th>
			<th>Position</th>
			<th>Numberofregistration</th>
		</tr>
		<%
			for (EmployeesDTO e : list) {
		%>
		<tr>
			<td><%=e.getName()%></td>
			<td><%=e.getSurname()%></td>
			<td><%=e.getFiscalcode()%></td>
			<td><%=e.getWorksector()%></td>
			<td><%=e.getPosition()%></td>
			<td><%=e.getNumberofregistration() %></td>

		</tr>
		<%
			}
		%>
	</table>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>