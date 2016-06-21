<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Comentarios</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
</head>
<body>
	
	<table border="1">
		<c:forEach var="c" items="${comentarios }">
			<tr>
				<td>${c.texto }</td>
				<td>${c.usuario.nome }</td>
				<td><a href="alterarComentarioFormulario?id=${c.id }">Alterar</a></td>
				<td><a href="apagarComentario?id=${c.id }">Apagar</a></td>
				
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>