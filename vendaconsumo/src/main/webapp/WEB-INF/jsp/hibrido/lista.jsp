<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hibrido lista</title>
</head>
<body>
	
	Lista de hibridos 
	
	<c:forEach var="hibrido" items="${hibridosLista}">
		<h4>${hibrido} <a href="/hibrido/excluir/${hibrido.id}">excluir</a> </h4>
	</c:forEach>
	
	<br><a href="/login">voltar</a>
</body>
</html>