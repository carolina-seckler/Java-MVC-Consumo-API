<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>venda lista</title>
</head>
<body>
	
	Lista de vendas 
	
	<c:forEach var="venda" items="${vendasLista}">
		<h4>${venda} <a href="/venda/excluir/${venda.id}">excluir</a> </h4>
	</c:forEach>
	
	<br><a href="/login">voltar</a>
</body>
</html>