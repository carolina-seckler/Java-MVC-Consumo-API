<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>usuario lista</title>
</head>
<body>
	
	Lista de usuários 
	
	<c:forEach var="usuario" items="${usuariosLista}">
		<h4>${usuario.nome} <a href="/usuario/excluir/${usuario.id}">excluir</a> </h4>
	</c:forEach>
	
	<br><a href="/login">voltar</a>
</body>
</html>