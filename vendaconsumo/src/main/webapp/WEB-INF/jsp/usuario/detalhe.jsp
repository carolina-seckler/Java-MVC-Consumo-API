<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>usuario detalhe</title>
</head>
<body>
	
	<form action="/usuario" method="post">
		Nome: <input type="text" name="nome">
		Login: <input type="text" name="login">
		Senha: <input type="password" name="senha">
		<input type="submit" value="Cadastrar">
	</form>
	
	<br><a href="/login">voltar</a>
</body>
</html>