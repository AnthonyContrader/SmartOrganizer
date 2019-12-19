<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WorkgroupDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Workgroup</title>
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
<%WorkgroupDTO w = (WorkgroupDTO) request.getAttribute("dto");%>

<table>
<tr>
<th>name</th>
<th>members</th>
<th>responsible</th>
<th>work</th>
</tr>
<tr>
<td><%=w.getName() %></td>
<td><%=w.getMembers() %></td>
<td><%=w.getResponsible() %></td>
<td><%=w.getWork() %></td>

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

<%@include file="../css/footer.jsp" %>
</body>
</html>