<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.WorkgroupDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Workgroup Manager</title>
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
<% List<WorkgroupDTO> list = (List<WorkgroupDTO>) request.getAttribute("list");%>
<br>

<table>
<tr>
<th>Name</th>
<th>Members</th>
<th>Responsible</th>
<th>Work</th>
<th></th>
<th></th>
</tr>
<% for(WorkgroupDTO w : list) { %>
<tr>
<td><a href=WorkgroupServlet?mode=read&idworkgroup=<%=w.getIdworkgroup()%>>
<%=w.getName() %>
</a></td>
<td><%=w.getMembers() %></td>
<td><%=w.getResponsible() %></td>
<td><%=w.getWork() %></td>
<td><a href=WorkgroupServlet?mode=read&update=true&idworkgroup=<%=w.getIdworkgroup() %>>Edit</a>
</td>
<td><a href=WorkgroupServlet?mode=delete&idworkgroup=<%=w.getIdworkgroup() %>>Delete</a>
</td>



</tr>

<%} %>



</table>

<form id="floatright" action="WorkgroupServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="inserisci name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">members</label>
    </div>
    <div class="col-75">
      <input type="text" id="members" name="members" placeholder="inserisci members"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">responsible</label>
    </div>
    <div class="col-75">
      <input type="text" id="responsible" name="responsible" placeholder="inserisci responsible"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">work</label>
    </div>
    <div class="col-75">
      <input type="text" id="work" name="work" placeholder="inserisci work"> 
    </div>
  </div>
  
  
  
      <button type="submit" >Insert</button>
</form>

</div>

<br>
<%@ include file="../css/footer.jsp" %>



</body>
</html>