<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WorkgroupDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Workgroup</title>
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
  
  <a href="LogoutServlet" id="logout">Logout</a>

</div>
<br>
<div class="main">

<%WorkgroupDTO w = (WorkgroupDTO) request.getAttribute("dto"); %>

<form id="floatleft" action="WorkgroupServlet?mode=update&idworkgroup=<%=w.getIdworkgroup() %>"method="post">
<div class="row">
<div class="col-25">
<label for="name">Name</label>
</div>
<div class=col-75>
<input type="text" id="name" name="name" value=<%=w.getName() %>>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="members">Members</label>
</div>
<div class=col-75>
<input type="text" id="members" name="members" value=<%=w.getMembers() %>>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="responsible">Responsible</label>
</div>
<div class=col-75>
<input type="text" id="responsible" name="responsible" value=<%=w.getResponsible() %>>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="work">work</label>
</div>
<div class=col-75>
<input type="text" id="work" name="work" value=<%=w.getWork() %>>
</div>
</div>
<button type="submit" >Edit</button>
</form>
</div>
</body>
</html>