<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cliente detalhe</title>
</head>
<body>
	
	<form action="/cliente" method="post">
		Nome: <input type="text" name="nome">
		CPF: <input type="text" name="cpf">
		E-mail: <input type="text" name="email">
		WhatsApp: <input type="text" name="whatsapp">
		Facebook: <input type="text" name="facebook">
		Instagram: <input type="text" name="instagram">

		<input type="submit" value="Cadastrar">
	</form>

	<br><a href="/login">voltar</a>
</body>
</html>