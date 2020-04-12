<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>venda detalhe</title>
</head>
<body>
	
	<form action="/venda" method="post">
		Dia: <input type="number" name="dia">
		Mês: <input type="number" name="mes">
		Ano: <input type="number" name="ano">
		
		<div>
		  	<c:if test="${clientesLista.size() gt 0}">
			  	<label for="idCliente">Cliente:</label>
			  	<select class="form-control" name="cliente">
			    	<c:forEach var="cliente" items="${clientesLista}">
				    	<option value="${cliente.id}">${cliente.nome}</option>
			    	</c:forEach>
		      	</select>
	    	</c:if>
	    	<c:if test="${clientesLista.size() le 0}">
	       		<label>Nenhum cliente disponível para venda!</label>
	       	</c:if>
		</div>
		
		<div>
		  	<c:if test="${produtosLista.size() gt 0}">
		  		<label>Produtos:</label>
		    	<c:forEach var="produto" items="${produtosLista}">
			  		<div class="container">
						<input type="checkbox" name="produtos" value="${produto.id}"> ${produto}
			  		</div>
		  		</c:forEach>
	   		</c:if>
	   	  	<c:if test="${produtosLista.size() le 0}">
	      		<label>Nenhum produto disponível para venda!</label>
	       	</c:if>
		</div>

		<input type="submit" value="Cadastrar">
	</form>
	
	<br><a href="/login">voltar</a>
</body>
</html>