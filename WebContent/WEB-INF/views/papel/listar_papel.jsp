<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Lista de Papeis</title>
</head>
<body>
	<table border="1">
		<c:forEach var="p" items="${papeis}">
			<tr>
				<td>${p.nome }</td>
				<td><a href="alterarPapelFormulario?id=${p.id }">Alterar</a></td>
				<td><a href="apagarPapel?id=${p.id }">Apagar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>