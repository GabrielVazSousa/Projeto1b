<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Login.css">
	<link href="${pageContext.request.contextPath}/resources/theme1/css/Login.css" rel="stylesheet" >
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Livvic:500&display=swap" rel="stylesheet">

    <title>Login Form</title>
</head>

<body>

<div class="login-form">

    <div class="login-container shadow">

        <div class="row">
            <h4 class="center white"> Cadastrar </h4>
        </div>

        <form class="login form col s12" action="efetuaRegistro" method="post" enctype="multipart/form-data">
            <div class="row">
                <div class="input-field col s12">
                    <input id="email" type="text" class="validate" required name="login">
                    <label for="email">Usuário</label>
                </div>

                <div class="input-field col s12">
                    <input id="password" type="password" class="validate" required name="senha">
                    <label for="password">Senha</label>
                </div>
                <div class="input-field col s12">
                    <input id="password2" type="password" class="validate" required name="senhaConfirmar">
                    <label for="password">Confirmar Senha</label>
                </div>

                <div class="col s12">
                    <input type="submit" value="Registrar" class="btn btn-small login-btn waves-effect white-text">
                </div>
                
				<div class="col s12">
                    <input type="button" class="btn btn-small login-btn waves-effect white-text" value="Voltar" onclick="location.href='login';" />
                </div>
			</div>
        </form>

        </div>
    </div>


<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>

</html>