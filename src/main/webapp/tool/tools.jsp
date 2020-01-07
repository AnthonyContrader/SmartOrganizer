<%@ page import="it.contrader.dto.ToolDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Tool Management">
<meta name="author" content="Angelo Tozza">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Tool Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/tool/getall">Tools</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<ToolDTO> list =(List<ToolDTO>) request.getSession().getAttribute("list");
		%>
		<br>
		<table>
			<tr>
			<th>Toolname</th>
			<th>Rawmaterial</th>
			<th></th>
			<th></th>
			</tr>
			<%
				for(ToolDTO t : list) {
			%>
			<tr>
				<td><a href="/tool/read?idtool=<%=t.getIdtool()%>"><%=t.getToolname()%></a></td>
				<td><%=t.getRawmaterial() %></td>
				<td><a href="/tool/preupdate?idtool=<%=t.getIdtool() %>">Edit</a></td>
				<td><a href="/tool/delete?idtool=<%=t.getIdtool() %>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
		
		<form id="floatright" action="/tool/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="tool">Toolname</label>
				</div>
				<div class="col-75">
					<input type="text" id="tool" name="toolname" placeholder="inserisci toolname">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="rawm">Rawmaterial</label>
				</div>
			<div class="col-75">
					<input type="text" id="rawm" name="rawmaterial"
						placeholder="inserisci rawmaterial">
			</div>
			</div>
			<button type="submit">Insert</button>
		</form>
	</div>
	<br>
	<%@ include file="../css/footer.jsp" %>
</body>
</html>