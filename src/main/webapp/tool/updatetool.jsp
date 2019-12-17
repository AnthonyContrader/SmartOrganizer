<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ToolDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Tool</title>
</head>
<body>
<%@include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist">Tools</a>
  <a class="active" href="LocationServlet?mode=locationlist">Locations</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">
<%ToolDTO t = (ToolDTO) request.getAttribute("dto"); %>
<form id ="floatleft" action="ToolServlet?mode=update&idtool=<%=t.getIdtool() %>" method="post">
	<div class="row">
		<div class="col-25">
			<label for="tool">Toolname</label>
		</div>
		<div class="col-75">
			<input type="text" id="tool" name="toolname" value=<%=t.getToolname() %>> 
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="rawm">Raw Material</label>
		</div>
		<div class="col-75">
			<input type="text" id="rawm" name ="rawmaterial" value=<%=t.getRawmaterial() %>>
		</div>
	</div>
		<button type="submit">Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>