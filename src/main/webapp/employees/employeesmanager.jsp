<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EmployeesDTO"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Employees Manager</title>
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
	<%
		List<EmployeesDTO> list = (List<EmployeesDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Fiscalcode</th>
			<th>Worksector</th>
			<th>Position</th>
			<th>Numberofregistration</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (EmployeesDTO e : list) {
		%>
		<tr>
			<td><a href=EmployeesServlet?mode=read&idemployee=<%=e.getIdemployee()%>>
					<%=e.getName()%>
			</a></td>
			<td><%=e.getSurname()%></td>
			<td><%=e.getFiscalcode()%></td>
			<td><%=e.getWorksector()%></td>
			<td><%=e.getPosition()%></td>
			<td><%=e.getNumberofregistration()%></td>
			<td><a href=EmployeesServlet?mode=read&update=true&id=<%=e.getIdemployee()%>>Edit</a>
			</td>
			<td><a href=EmployeesServlet?mode=delete&id=<%=e.getIdemployee()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="EmployeesServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="inserisci il tuo nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="surname">surname</label>
    </div>
    <div class="col-75">
      <input type="text" id="surname" name="surname" placeholder="inserisci il tuo cognome"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="fiscalcode">fiscalcode</label>
    </div>
    <div class="col-75">
      <input type="text" id="fiscalcode" name="fiscalcode" placeholder="inserisci il tuo codice fiscale">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="worksector">worksector</label>
    </div>
    <div class="col-75">
      <input type="text" id="worksector" name="worksector" placeholder="inserisci il settore di lavoro">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="position">position</label>
    </div>
    <div class="col-75">
      <input type="text" id="position" name="position" placeholder="inserisci la tua posizione lavorativa">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="numberofregistration">numberofregistration</label>
    </div>
    <div class="col-75">
      <input type="text" id="numberofregistration" name="numberofregistration" placeholder="inserisci il numero di matricola">
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>