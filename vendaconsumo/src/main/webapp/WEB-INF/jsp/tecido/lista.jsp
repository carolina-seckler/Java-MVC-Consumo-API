<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tecido lista</title>
</head>
<body>
	
	Lista de tecidos 
	
	<c:forEach var="tecido" items="${tecidosLista}">
		<h4>${tecido} <a href="/tecido/excluir/${tecido.id}">excluir</a> </h4>
	</c:forEach>
	
	<br><a href="/login">voltar</a>
</body>
</html>