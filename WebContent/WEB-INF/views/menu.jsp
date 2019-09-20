<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
 <p>Bem vindo, ${usuarioLogado}</p>
 <form action="efetuaCriacaoNota" method="post">
 <input type="button" value="Criar notas" onclick="location.href='cnotas';" />
</form>
</body>
<a href="logout">Sair do sistema</a>
<img src="getImage?login=${usuarioLogado}" />
</html>