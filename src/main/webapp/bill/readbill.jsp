<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.BillDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Bill</title>
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
  <a class="active" href="BillServlet?mode=billList">Bills</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%BillDTO b = (BillDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		    <th>Idbill</th>
			<th>Numberbill</th>
			<th>Date</th>
			<th>Customer</th>
			<th>Price</th>
			<th>Location</th>
		</tr>
		<%
			for (BillDTO b : list) {
		%>
		<tr>
		    <td><%=b.getIdbill()%></td>
			<td><%=b.getNumberbill()%></td>
			<td><%=b.getDate()%></td>
			<td><%=b.getCustomer()%></td>
			<td><%=b.getPrice()%></td>
			<td><%=b.getLocation()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>