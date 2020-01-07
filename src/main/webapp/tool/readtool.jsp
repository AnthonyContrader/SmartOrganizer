<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ToolDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Tool Read">
<meta name="author" content="Tool Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Tool</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a href="/user/getall">Users</a>
		<a class="active" href="/tool/getall">Tools</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			ToolDTO u = (ToolDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>IDTool</th>
				<th>Toolname</th>
				<th>Rawmaterial</th>
			</tr>
			<tr>
				<td><%=u.getIdtool()%></td>
				<td><%=u.getToolname()%></td>
				<td><%=u.getRawmaterial()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>