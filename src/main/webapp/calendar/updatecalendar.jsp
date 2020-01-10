<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CalendarDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Calendar Edit page">
<meta name="author" content="Angelo Tozza">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Calendar</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a class="active" href="/tool/getall">Tools</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">
	<%CalendarDTO u = (CalendarDTO) request.getSession().getAttribute("dto");%>
	
	<form id="floatleft" action="/calendar/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="date">Date</label>
				</div>
				<div class="col-75">
					<input type="date" id="date" name="date" value=<%=u.getDate() %>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="checkin">Checkin</label>
				</div>
			<div class="col-75">
					<input type="text" id="checkin" name="checkin" value=<%=u.getCheckin() %>>
			</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="checkout">Checkout</label>
				</div>
			<div class="col-75">
					<input type="text" id="checkout" name="checkout" value=<%=u.getCheckout() %>>
			</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="employee">Employee</label>
				</div>
			<div class="col-75">
					<input type="text" id="employee" name="employee" value=<%=u.getEmployee().getIdemployee() %>>
			</div>
			<input type="hidden" name="idcalendar" value=<%=u.getIdcalendar()%>>
			</div>
			<button type="submit">Edit</button>
		</form>
	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>