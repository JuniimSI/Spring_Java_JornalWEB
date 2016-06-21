<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Comentario</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
</head>
<body>
	<form action="inserirComentario" method="post">
			<img width="300" height="200" alt="${n.titulo}" src="<c:url value="/resources/images/${noticia.imagem}.png" />" />  
		
			${noticia.titulo} <br />
			${noticia.subtitulo }<br />
			${noticia.texto }<br />
			${noticia.data }<br /> 
			${noticia.usuario.nome}<br/>
			
		Texto: <input type="text" name="texto" /> 
			<form:errors path="comentario.texto" />   <br />
		<input type="hidden" name="noticiaId" value="${noticia.id}"/>  
		<input type="hidden" name="usuarioId" value="${usuario_logado.id}" />
		<input type="submit" value="Comentar"/>
		
	</form>

</body>
</html>