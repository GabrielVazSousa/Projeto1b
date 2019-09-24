<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css">
<div class="topnav">
  <input type="button" value="Home" onclick="location.href='menu';" />
  <input type="button" value="Visualizar Notas" onclick="location.href='vnotas';" />
  <input type="button" value="Criar notas" onclick="location.href='cnotas';" />
</div>
</head>
<body>
 <p>Bem vindo, ${usuarioLogado}</p>
</body>
<input type="button" value="Sair do sistema" onclick="location.href='logout';" />
</html>

