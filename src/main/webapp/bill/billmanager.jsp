<%@page import="it.contrader.model.Bill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.BillDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Bill Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist">Tools</a>
  <a class="active" href="LocationServlet?mode=locationlist">Locations</a>
  <a class="active" href="WorkgroupServlet?mode=workgrouplist">Workgroups</a>
  <a class="active" href="CalendarServlet?mode=calendarlist">Calendar</a>
  <a class="active" href="BillServlet?mode=billlist">Bills</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<BillDTO> list = (List<BillDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		    <th>Idbill</th>
			<th>Numberbill</th>
			<th>Date</th>
			<th>Customer</th>
			<th>Price</th>
			<th>Location</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (BillDTO b : list) {
		%>
		<tr>
			<td><a href=BillServlet?mode=read&idbill=<%=b.getIdbill()%>></a>
			<%=b.getIdbill()%></td>
			<td><%=b.getNumberbill()%></td>
			<td><%=b.getDate()%></td>
			<td><%=b.getCustomer()%></td>
			<td><%=b.getPrice()%></td>
			<td><%=b.getLocation()%></td>
			<td><a href=BillServlet?mode=read&update=true&idbill=<%=b.getIdbill()%>>Edit</a>
			</td>
			<td><a href=BillServlet?mode=delete&idbill=<%=b.getIdbill()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="BillServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="numberbill">numberbill</label>
    </div>
    <div class="col-75">
      <input type="text" id="numberbill" name="numberbill" placeholder="inserisci il numero della fattura">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="date">date</label>
    </div>
    <div class="col-75">
      <input type="text" id="date" name="date" placeholder="inserisci la data della fattura"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="customer">customer</label>
    </div>
    <div class="col-75">
      <input type="text" id="customer" name="customer" placeholder="inserisci il nome del cliente">
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
      <input type="text" id="location" name="location" placeholder="inserisci la posizione">
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>