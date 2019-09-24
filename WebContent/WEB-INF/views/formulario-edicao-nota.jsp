<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CriaNotas.css">
</head>
<body>
<div class="container">  
  <form action="enota" method="post" enctype="multipart/form-data">
  	<input type="hidden" name="Id" value="${nota.id}">
    <h3>Edite sua Nota!</h3>
    <fieldset>
      <input placeholder="Titulo" name="name" type="text" tabindex="1" value="${nota.name}" required autofocus>
    </fieldset>
    <fieldset>
      <input placeholder="Escreva a categoria aqui...." name="label" tabindex="2" value="${nota.label}" required>
    </fieldset>
    <fieldset>
      <textarea placeholder="Escreva o texto aqui...." name="text" tabindex="3" required>${nota.text}</textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Enviando">Enviar!</button>
    </fieldset>
  </form>
</div>
</body>
</html>