<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Inserir Oferta Formulario</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
</head>
<body>
	
	<form action="inserirOferta" method="post">
		<input type="hidden" name="usuarioId" value="${usuario_logado.id}" />
		<input type="hidden" name="id" value="${classificado.id}" /> 
	    <input type="hidden" name="titulo" value="${classificado.titulo }"/>   
		<input type="hidden" name="texto" value="${classificado.texto }"/> 
			<form:errors path="classificado.texto" /> 
		<input type="hidden" name="telefone" value="${classificado.telefone }"/>
		<input type="hidden" name="preco" value="${classificado.preco }"/> 
		
		Oferta: <input type="text" name="melhorOferta" /> <br />
		
		<input type="submit" value="Inserir Oferta"/>	
	</form>
</body>
</html>