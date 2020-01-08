<%@ page import="it.contrader.dto.WorkgroupDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Eorkgroup Management">
<meta name="author" content="Ivan Schillizzi">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Workgroup Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<WorkgroupDTO> list = (List<WorkgroupDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Members</th>
				<th>Responsible</th>
				<th>work</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (WorkgroupDTO l : list) {
			%>
			<tr>
				<td><a href="/workgroup/read?idworkgroup=<%=l.getIdworkgroup()%>"> <%=l.getName()%></a></td>
				<td><%=l.getMembers()%></td>
				<td><%=l.getResponsible()%></td>
				<td><%=l.getWork()%></td>
				<td><a href="/workgroup/preupdate?idworkgroup=<%=l.getIdworkgroup()%>">Edit</a></td>


				<td><a href="/workgroup/delete?idworkgroup=<%=l.getIdworkgroup()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/workgroup/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="inserisci il nome del gruppo di lavoro">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="members">Members</label>
				</div>
				<div class="col-75">
					<input type="text" id="members" name="members"
						placeholder="inserisci i membri del gruppo">
				</div>
			</div>
			
				<div class="row">
				<div class="col-25">
					<label for="responsible">Responsible</label>
				</div>
				<div class="col-75">
					<input type="text" id="responsible" name="responsible"
						placeholder="inserisci il responsabile del gruppo di lavoro">
				</div>
			</div>
				<div class="row">
				<div class="col-25">
					<label for="work">Work</label>
				</div>
				<div class="col-75">
					<input type="text" id="work" name="work"
						placeholder="inserisci il lavoro">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>