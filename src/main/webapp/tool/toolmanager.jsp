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
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist">Tools</a>
  <a class="active" href="LocationServlet?mode=locationlist">Locations</a>
  <a class="active" href="WorkgroupServlet?mode=workgrouplist">Workgroups</a>
  <a class="active" href="CalendarServlet?mode=calendarlist">Calendar</a>
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
			<th></th>
			<th></th>
		</tr>
		<%
			for(ToolDTO t : list){
		%>
		<tr>
			<td><a href=ToolServlet?mode=read&idtool=<%=t.getIdtool()%>><%=t.getToolname()%></a></td>
			<td><%=t.getRawmaterial() %></td>
			<td><a href=ToolServlet?mode=read&update=true&idtool=<%=t.getIdtool() %>>Edit</a></td>
			<td><a href=ToolServlet?mode=delete&idtool=<%=t.getIdtool() %>>Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
<form id="floatright" action="ToolServlet?mode=insert" method="post">
	<div class="row">
		<div class="col-25">
			<label for="tool">Toolname</label>
		</div>
		<div class="col-75">
			<input type="text" id="tool" name="toolname" placeholder="inserisci toolname">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="rawm">Raw Material</label>
		</div>
		<div class="col-75">
			<input type="text" id="rawm" name="rawmaterial" placeholder="inserisci rawmaterial">
		</div>
	</div>
	<button type="submit">Insert</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp"%>
</body>
</html>