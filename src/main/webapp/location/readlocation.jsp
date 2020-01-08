<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.LocationDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Location</title>
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
			LocationDTO l = (LocationDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Address</th>
				<th>City</th>
				<th>Typeoflocation</th>
				<th>Worktype</th>
			</tr>
			<tr>
				<td><%=l.getId()%></td>
				<td><%=l.getAddress()%></td>
				<td><%=l.getCity()%></td>
				<td><%=l.getTypeoflocation()%></td>
				<td><%=l.getWorktype()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>