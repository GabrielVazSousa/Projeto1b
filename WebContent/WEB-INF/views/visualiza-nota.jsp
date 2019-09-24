<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/VisualizaNotas.css">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300i,400" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="VisualizaNotas.css">
</head>
<body>
<div class="container">
<%@page import="java.io.IOException,
					java.io.PrintWriter,
					java.util.Calendar,
					java.util.List,
					javax.servlet.ServletException,
					javax.servlet.annotation.WebServlet,
					javax.servlet.http.HttpServlet,
					javax.servlet.http.HttpServletRequest,
					javax.servlet.http.HttpServletResponse,
					mvc.model.*,
					mvc.controller.*"%>
<div class="topnav">
  <input type="button" value="Home" onclick="location.href='menu';" />
  <input type="button" value="Visualizar Notas" onclick="location.href='vnotas';" />
  <input type="button" value="Criar notas" onclick="location.href='cnotas';" />
	<form action="snotas" method="get">
		Pesquisa por nome:	<input type="text" name="name">
		<input type="submit" value="Pesquisar" />
	</form>
	
</div>

<c:forEach var="nota" items="${notas}">
  <div class="card">
  	<div class="row">
  		<div>
	  		<form action="dnota" method="get">
	  		  <input type="hidden" name="Id" value="${nota.id}">
	  		  <input type="submit" value="Apagar" />
	  		</form>
	  		<form action="goEnota" method="get">
	  		  <input type="hidden" name="Id" value="${nota.id}">
	  		  <input type="submit" value="Editar" />
	  		</form>
  		</div>
  		<h3 class="title">${nota.name}</h3>
  	</div>
    <h4 class="label">${nota.label}</h4>
    <div class="bar">
      <div class="emptybar"></div>
      <div class="filledbar"></div>
    </div>
    <h5 class="text">${nota.text}</h5>
    <div>
    <h6 class="datetime">${nota.ts}</h6>
    </div>
  </div>
</c:forEach>
</div>
</body>
</html>




