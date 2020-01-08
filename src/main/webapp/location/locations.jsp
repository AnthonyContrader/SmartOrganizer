<%@ page import="it.contrader.dto.LocationDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Location Management">
<meta name="author" content="Ivan Schillizzi">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Location Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<LocationDTO> list = (List<LocationDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Address</th>
				<th>City</th>
				<th>typeoflocation</th>
				<th>worktype</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (LocationDTO l : list) {
			%>
			<tr>
				<td><a href="/location/read?id=<%=l.getId()%>"> <%=l.getAddress()%></a></td>
				<td><%=l.getCity()%></td>
				<td><%=l.getTypeoflocation()%></td>
				<td><%=l.getWorktype()%></td>
				<td><a href="/location/preupdate?id=<%=l.getId()%>">Edit</a></td>


				<td><a href="/location/delete?id=<%=l.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/location/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="address">Address</label>
				</div>
				<div class="col-75">
					<input type="text" id="address" name="address"
						placeholder="inserisci l'indirizzo">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="city">City</label>
				</div>
				<div class="col-75">
					<input type="text" id="city" name="city"
						placeholder="inserisci la città">
				</div>
			</div>
			
				<div class="row">
				<div class="col-25">
					<label for="typeoflocation">Typeoflocation</label>
				</div>
				<div class="col-75">
					<input type="text" id="typeoflocation" name="typeoflocation"
						placeholder="inserisci il tipo di località">
				</div>
			</div>
				<div class="row">
				<div class="col-25">
					<label for="worktype">Worktype</label>
				</div>
				<div class="col-75">
					<input type="text" id="worktype" name="worktype"
						placeholder="inserisci il tipo di lavoro">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>