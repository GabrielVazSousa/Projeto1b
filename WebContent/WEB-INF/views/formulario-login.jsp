<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
 <h2>Página de Login</h2>
 <form action="efetuaLogin" method="post">
 Login: <input type="text" name="login" /> <br/>
 Senha: <input type="password" name="senha" /> <br/>
 <input type="submit" value="Entrar nas tarefas" />
<input type="button" class="button_active" value="Cadastrar" onclick="location.href='registro';" />
</form>
</body>
</html>