<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.CalendarDTO"
	import="java.util.List"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Calendar Read">
<meta name="author" content="Angelo Tozza">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Filtered Calendar</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a class="active" href="/calendar/getall">Calendar</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
<br>

	<div class="main">
		<%
			List<CalendarDTO> list =(List<CalendarDTO>) request.getSession().getAttribute("filteredlist");
		%>


		<table>
		<%for(CalendarDTO u : list){ %>
			<tr>
				<th>IDCalendar</th>
				<th>Date</th>
				<th>Checkin</th>
				<th>Checkout</th>
				<th>Employee</th>
			</tr>
			<tr>
				<td><%=u.getIdcalendar()%></td>
				<td><%=u.getDate()%></td>
				<td><%=u.getCheckin()%></td>
				<td><%=u.getCheckout()%></td>
				<td><%=u.getEmployee().getIdemployee()+" - "+u.getEmployee().getName()+" "+u.getEmployee().getSurname()%></td>
			</tr>
			<%
				}
			%>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>