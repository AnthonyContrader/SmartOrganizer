<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.BillDTO"
    import="java.util.List"%>
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
		<%
			}
		%>
	</table>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>