<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EmployeesDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Employees</title>
</head>
<body>
<%@include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist">Tools</a>
  <a class="active" href="LocationServlet?mode=location">Locations</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">
<%EmployeesDTO e = (EmployeesDTO) request.getAttribute("dto"); %>
<form id ="floatleft" action="EmployeesServlet?mode=update&idemployee=<%=e.getIdemployee() %>" method="post">
	<div class="row">
		<div class="col-25">
			<label for="name">name</label>
		</div>
		<div class="col-75">
			<input type="text" id="name" name="name" value=<%=e.getName() %>> 
		</div>
	</div>
		<div class="row">
		<div class="col-25">
			<label for="surname">surname</label>
		</div>
		<div class="col-75">
			<input type="text" id="surname" name="surname" value=<%=e.getSurname() %>> 
		</div>
	</div>
		<div class="row">
		<div class="col-25">
			<label for="fiscalcode">fiscalcode</label>
		</div>
		<div class="col-75">
			<input type="text" id="fiscalcode" name="fiscalcode" value=<%=e.getFiscalcode() %>> 
		</div>
	</div>
		<div class="row">
		<div class="col-25">
			<label for="worksector">worksector</label>
		</div>
		<div class="col-75">
			<input type="text" id="worksector" name="worksector" value=<%=e.getWorksector() %>> 
		</div>
	</div>
		<div class="row">
		<div class="col-25">
			<label for="position">position</label>
		</div>
		<div class="col-75">
			<input type="text" id="position" name="position" value=<%=e.getPosition() %>> 
		</div>
	</div>
		<div class="row">
		<div class="col-25">
			<label for="numberofregistration">numberofregistration</label>
		</div>
		<div class="col-75">
			<input type="text" id="numberofregistration" name="numberofregistration" value=<%=e.getNumberofregistration() %>> 
		</div>
	</div>
		<button type="submit">Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>