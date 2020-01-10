<%@ page import="it.contrader.dto.CalendarDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Calendar Management">
<meta name="author" content="Angelo Tozza">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Calendar Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a href="/tool/getall">Tools</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<CalendarDTO> list =(List<CalendarDTO>) request.getSession().getAttribute("list");
		%>
		<br>
		<table>
			<tr>
			<th>Date</th>
			<th>Checkin</th>
			<th>Checkout</th>
			<th>Employee</th>
			<th></th>
			<th></th>
			</tr>
			<%
				for(CalendarDTO c : list) {
			%>
			<tr>
				<td><a href="/calendar/read?idcalendar=<%=c.getIdcalendar()%>"><%=c.getDate()%></a></td>
				<td><%=c.getCheckin() %></td>
				<td><%=c.getCheckout() %></td>
				<td><a href="/calendar/filter?employee=<%=c.getEmployee().getIdemployee()%>"><%=c.getEmployee().getName()+" "+c.getEmployee().getSurname()%></a></td>
				<td><a href="/calendar/preupdate?idcalendar=<%=c.getIdcalendar() %>">Edit</a></td>
				<td><a href="/calendar/delete?idcalendar=<%=c.getIdcalendar() %>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
		
		<form id="floatright" action="/calendar/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="date">Date</label>
				</div>
				<div class="col-75">
					<input type="date" id="date" name="date">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="checkin">Checkin</label>
				</div>
			<div class="col-75">
					<input type="text" id="checkin" name="checkin"
						placeholder="inserisci checkin">
			</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="checkout">Checkout</label>
				</div>
			<div class="col-75">
					<input type="text" id="checkout" name="checkout"
						placeholder="inserisci checkout">
			</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="employee">Employee</label>
				</div>
			<div class="col-75">
					<input type="text" id="employee" name="employee"
						placeholder="inserisci employee">
			</div>
			</div>
			<button type="submit">Insert</button>
		</form>
	</div>
	<br>
	<%@ include file="../css/footer.jsp" %>
</body>
</html>