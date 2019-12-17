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
<%@ include file="../css/header.jsp" %>
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

<%EmployeesDTO e = (EmployeesDTO) request.getAttribute("dto");%>


<form id="floatleft" action="EmployeesServlet?mode=update&id=<%=e.getIdemployee()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="inserisci il tuo nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="surname">Surname</label>
    </div>
    <div class="col-75">
      <input type="text" id="surname" name="surname" placeholder="inserisci il tuo cognome"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="fiscalcode">Fiscalcode</label>
    </div>
    <div class="col-75">
      <input type="text" id="fiscalcode" name="fiscalcode" placeholder="inserisci il tuo codice fiscale">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="worksector">Worksector</label>
    </div>
    <div class="col-75">
      <input type="text" id="worksector" name="worksector" placeholder="inserisci il settore di lavoro">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="position">Position</label>
    </div>
    <div class="col-75">
      <input type="text" id="position" name="position" placeholder="inserisci la tua posizione lavorativa">
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>