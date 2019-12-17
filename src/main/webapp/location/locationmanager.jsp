<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.LocationDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Location Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
<a  href="homeadmin.jsp">Home</a>
<a class="active" href="UserServlet?mode=userlist">Users</a>
<a class="active" href="EmployeesServlet?mode=employeeslist">Employees</a>
  <a class="active" href="ToolServlet?mode=toollist">Tools</a>
<a class="active" href="LocationServlet?mode=locationlist">Locations</a>
<a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
<% List<LocationDTO> list = (List<LocationDTO>) request.getAttribute("list");%>
<br>

<table>
<tr>
<th>Address</th>
<th>City</th>
<th>Typeoflocation</th>
<th>worktype</th>
<th></th>
<th></th>
</tr>
<% for(LocationDTO l : list) { %>
<tr>
<td><a href=LocationServlet?mode=read&idlocation=<%=l.getIdlocation()%>>
<%=l.getAddress() %>
</a></td>
<td><%=l.getCity() %></td>
<td><%=l.getTypeoflocation() %></td>
<td><%=l.getWorktype() %></td>
<td><a href=LocationServlet?mode=read&update=true&idlocation=<%=l.getIdlocation() %>>Edit</a></td>
<td><a href=LocationServlet?mode=delete&idlocation=<%=l.getIdlocation() %>>Delete</a>
</td>



</tr>

<%} %>



</table>

<form id="floatright" action="LocationServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="address">address</label>
    </div>
    <div class="col-75">
      <input type="text" id="address" name="address" placeholder="inserisci address">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">city</label>
    </div>
    <div class="col-75">
      <input type="text" id="city" name="city" placeholder="inserisci city"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">typeoflocation</label>
    </div>
    <div class="col-75">
      <input type="text" id="typeoflocation" name="typeoflocation" placeholder="inserisci typeoflocation"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">worktype</label>
    </div>
    <div class="col-75">
      <input type="text" id="worktype" name="worktype" placeholder="inserisci worktype"> 
    </div>
  </div>
  
  
  
      <button type="submit" >Insert</button>
</form>

</div>

<br>
<%@ include file="../css/footer.jsp" %>



</body>
</html>