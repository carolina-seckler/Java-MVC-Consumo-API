<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cartonagem detalhe</title>
</head>
<body>
	
	<form action="/cartonagem" method="post">
		Código: <input type="text" name="codigo">
		Nome: <input type="text" name="nome">
		Descrição: <input type="text" name="descricao">
		Preço: <input type="text" name="preco">
		Preço de fabricação: <input type="text" name="precoMaterial">
		<label><input type="checkbox" id="tecido" name="tecido" value="true"> Tecido?</label>
		<label><input type="checkbox" id="tecidoImpermeabilizado" name="tecidoImpermeabilizado" value="true"> Tecido impermeabilizado?</label>
		<label><input type="checkbox" id="sintetico" name="sintetico" value="true"> Sintético?</label>

		<input type="submit" value="Cadastrar">
	</form>
	
	<br><a href="/login">voltar</a>
</body>
</html>