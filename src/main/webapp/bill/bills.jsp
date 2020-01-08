<%@ page import="it.contrader.dto.BillDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Bill Management">
<meta name="author" content="Felice Ricciardi">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Bill Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/tool/getall">Tools</a>
		<a class="active" href="/bill/getall">Bills</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<BillDTO> list =(List<BillDTO>) request.getSession().getAttribute("list");
		%>
		<br>
		<table>
			<tr>
			<th>Numberbill</th>
			<th>Date</th>
			<th>Customer</th>
			<th>Price</th>
			<th>Location</th>
			<th></th>
			<th></th>
			</tr>
			<%
				for(BillDTO b : list) {
			%>
			<tr>
				<td><a href="/bill/read?idbill=<%=b.getIdbill()%>"><%=b.getNumberbill()%></a></td>
				<td><%=b.getDate() %></td>
				<td><%=b.getCustomer() %></td>
				<td><%=b.getPrice() %></td>
				<td><%=b.getLocation() %></td>
				<td><a href="/bill/preupdate?idbill=<%=b.getIdbill() %>">Edit</a></td>
				<td><a href="/bill/delete?idbill=<%=b.getIdbill() %>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
		
		<form id="floatright" action="/bill/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="numberbill">numberbill</label>
				</div>
				<div class="col-75">
					<input type="text" id="numberbill" name="numberbill" placeholder="inserisci numero di fattura">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="date">date</label>
				</div>
			<div class="col-75">
					<input type="text" id="date" name="date"
						placeholder="dd-MM-yyyy">
			</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="customer">customer</label>
				</div>
				<div class="col-75">
					<input type="text" id="customer" name="customer" placeholder="inserisci cliente">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="price">price</label>
				</div>
				<div class="col-75">
					<input type="text" id="price" name="price" placeholder="inserisci il prezzo">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="location">location</label>
				</div>
				<div class="col-75">
					<input type="text" id="location" name="location" placeholder="inserisci il luogo">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>
	</div>
	<br>
	<%@ include file="../css/footer.jsp" %>
</body>
</html>