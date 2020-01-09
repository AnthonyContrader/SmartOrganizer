<%@ page import="it.contrader.dto.EmployeesDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Employees Management">
<meta name="author" content="Felice Ricciardi">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Employees Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/employees/getall">Employees</a>
		<a class="active" href="/tool/getall">Tools</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<EmployeesDTO> list = (List<EmployeesDTO>) request.getSession().getAttribute("list");
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
				<th>Workgroup</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (EmployeesDTO e : list) {
			%>
			<tr>
				<td><a href="/employees/read?idemployee=<%=e.getIdemployee()%>"> <%=e.getName()%>
				</a></td>
				<td><%=e.getSurname()%></td>
				<td><%=e.getFiscalcode()%></td>
				<td><%=e.getWorksector()%></td>
				<td><%=e.getPosition()%></td>
				<td><%=e.getNumberofregistration()%></td>
				<td><%=e.getWorkgroup()%></td>
				<td><a href="/employees/preupdate?idemployee=<%=e.getIdemployee()%>">Edit</a></td>


				<td><a href="/employees/delete?idemployee=<%=e.getIdemployee()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/employees/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">name</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="inserisci il tuo nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="surname">surname</label>
				</div>
				<div class="col-75">
					<input type="text" id="surname" name="surname"
						placeholder="inserisci il tuo cognome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="fiscalcode">fiscalcode</label>
				</div>
				<div class="col-75">
					<input type="text" id="fiscalcode" name="fiscalcode"
						placeholder="inserisci il tuo codice fiscale">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="worksector">worksector</label>
				</div>
				<div class="col-75">
					<input type="text" id="worksector" name="worksector"
						placeholder="inserisci il tuo settore di lavoro">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="position">position</label>
				</div>
				<div class="col-75">
					<input type="text" id="position" name="position"
						placeholder="inserisci la tua posizione di lavoro">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="numberofregistration">numberofregistration</label>
				</div>
				<div class="col-75">
					<input type="text" id="numberofregistration" name="numberofregistration"
						placeholder="inserisci il tuo numero di matricola">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="workgroup">workgroup</label>
				</div>
				<div class="col-75">
					<input type="text" id="workgroup" name="workgroup"
						placeholder="inserisci il tuo gruppo di lavoro">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>