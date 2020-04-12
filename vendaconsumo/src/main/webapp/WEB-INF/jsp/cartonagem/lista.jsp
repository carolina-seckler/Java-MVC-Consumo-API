<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cartonagem lista</title>
</head>
<body>
	
	Lista de cartonagens 
	
	<c:forEach var="cartonagem" items="${cartonagensLista}">
		<h4>${cartonagem} <a href="/cartonagem/excluir/${cartonagem.id}">excluir</a> </h4>
	</c:forEach>
	
	<br><a href="/login">voltar</a>
</body>
</html>