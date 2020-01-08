<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.LocationDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Location</title>

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

<%LocationDTO l = (LocationDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/location/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="address">Address</label>
    </div>
    <div class="col-75">
      <input type="text" id="address" name="address" value=<%=l.getAddress()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="city">City</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="city" name="city" value=<%=l.getCity()%>> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="typeoflocation">Typeoflocation</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="typeoflocation" name="typeoflocation" value=<%=l.getTypeoflocation()%>> 
    </div>
  </div>
  
    <div class="row">
    <div class="col-25">
     <label for="worktype">Worktype</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="worktype" name="worktype" value=<%=l.getWorktype()%>> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="id">id</label>
    </div>
    <div class="col-75">
      <input
			type="hidden" name="id" value=<%=l.getId()%>> 
    </div>
  </div>
 
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>