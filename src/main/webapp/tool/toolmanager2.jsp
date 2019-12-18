<%@page import="it.contrader.model.Tool"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.ToolDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Tool Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeuser.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist&usermode=true">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist&usermode=true">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist&usermode=true">Tools</a>
  <a class="active" href="LocationServlet?mode=locationlist&usermode=true">Locations</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
<%
List<ToolDTO> list = (List<ToolDTO>) request.getAttribute("list");
%>
<br>
	<table>
		<tr>
			<th>ToolName</th>
			<th>RawMaterial</th>
		</tr>
		<%
			for(ToolDTO t : list){
		%>
		<tr>
			<td><%=t.getToolname()%></td>
			<td><%=t.getRawmaterial() %></td>
		</tr>
		<%
			}
		%>
	</table>
</div>
<br>
<%@ include file="../css/footer.jsp"%>
</body>
</html>