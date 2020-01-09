<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.EmployeesDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Employees Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Employees</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a href="/user/getall">Users</a>
		<a class="active" href="/employees/getall">Employees</a>
		<a class="active" href="/tool/getall">Tools</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			EmployeesDTO e = (EmployeesDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>Idemployee</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Fiscalcode</th>
				<th>Worksector</th>
				<th>Position</th>
				<th>Numberofregistration</th>
				<th>Workgroup</th>
			</tr>
			<tr>
				<td><%=e.getIdemployee()%></td>
				<td><%=e.getName()%></td>
				<td><%=e.getSurname()%></td>
				<td><%=e.getFiscalcode()%></td>
				<td><%=e.getWorksector()%></td>
				<td><%=e.getPosition()%></td>
				<td><%=e.getNumberofregistration()%></td>
				<td><%=e.getWorkgroup()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>