<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WorkgroupDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Ivan Schillizzi">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Workgroup</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%WorkgroupDTO l = (WorkgroupDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/workgroup/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=l.getName()%>>
    </div>
  </div>
  
    <div class="row">
    <div class="col-25">
     <label for="responsible">Responsible</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="responsible" name="responsible" value=<%=l.getResponsible()%>> 
    </div>
  </div>
  
    <div class="row">
    <div class="col-25">
     <label for="work">Work</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="work" name="work" value=<%=l.getWork()%>> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="id">id</label>
    </div>
    <div class="col-75">
      <input
			type="hidden" name="idworkgroup" value=<%=l.getIdworkgroup()%>> 
    </div>
  </div>
 
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>