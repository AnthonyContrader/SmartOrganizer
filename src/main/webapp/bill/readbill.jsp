<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.BillDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Bill Read">
<meta name="author" content="Felice Ricciardi">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Bill</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a href="/user/getall">Users</a>
		<a class="active" href="/tool/getall">Tools</a>
		<a class="active" href="/bill/getall">Bills</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			BillDTO b = (BillDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>Idbill</th>
				<th>Numberbill</th>
				<th>Date</th>
				<th>Customer</th>
				<th>Price</th>
				<th>Location</th>
			</tr>
			<tr>
				<td><%=b.getIdbill()%></td>
				<td><%=b.getNumberbill()%></td>
				<td><%=b.getDate()%></td>
				<td><%=b.getCustomer()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getLocation()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>