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
  <form action="efetuaCriacaoNota" method="post" enctype="multipart/form-data">
    <h3>Crie sua Nota!</h3>
    <fieldset>
      <input placeholder="Titulo" name="name" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input placeholder="Escreva a categoria aqui...." name="label" tabindex="2" required>
    </fieldset>
    <fieldset>
      <textarea placeholder="Escreva o texto aqui...." name="text" tabindex="3" required></textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Enviando">Enviar!</button>
    </fieldset>
  </form>
</div>
</body>
</html>