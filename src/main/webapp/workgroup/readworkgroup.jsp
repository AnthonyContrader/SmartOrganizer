<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.WorkgroupDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Workgroup</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			WorkgroupDTO l = (WorkgroupDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Members</th>
				<th>Responsible</th>
				<th>Work</th>
			</tr>
			<tr>
				<td><%=l.getIdworkgroup()%></td>
				<td><%=l.getName()%></td>
				<td><%=l.getMembers()%></td>
				<td><%=l.getResponsible()%></td>
				<td><%=l.getWork()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>