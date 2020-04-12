<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cliente lista</title>
</head>
<body>
	
	Lista de clientes 
	
	<c:forEach var="cliente" items="${clientesLista}">
		<h4>${cliente} <a href="/cliente/excluir/${cliente.id}">excluir</a> </h4>
	</c:forEach>
	
	<br><a href="/login">voltar</a>
</body>
</html>