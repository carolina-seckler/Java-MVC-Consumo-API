<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<font color="red">${msg}</font>
	<form action="/login" method="post">
		Login: <input type="text" name="login">
		Senha: <input type="password" name="senha">
		<input type="submit" value="Acessar">
	</form>

</body>
</html>