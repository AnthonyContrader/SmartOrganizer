<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ToolDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Tool Edit page">
<meta name="author" content="Angelo Tozza">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Tool</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a class="active" href="/tool/getall">Tools</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ToolDTO u = (ToolDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/tool/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tool">ToolName</label>
    </div>
    <div class="col-75">
      <input type="text" id="tool" name="toolname" value=<%=u.getToolname()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="rawm">Rawmaterial</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="rawn" name="rawmaterial" value=<%=u.getRawmaterial()%>> 
    </div>
    <input type="hidden" name="idtool" value =<%=u.getIdtool()%>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>