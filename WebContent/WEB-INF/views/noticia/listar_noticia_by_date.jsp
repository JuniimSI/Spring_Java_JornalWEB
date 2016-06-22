<%@page import="org.apache.taglibs.standard.tag.common.xml.IfTag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<title>Lista de noticias</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>

   <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
	
</head>
<body>
	<div class="container-fluid">
		<c:forEach var="n" items="${noticias}"> 
			<c:if test="${n.ativo == true }">
				<div class="panel panel-primary">
					<div align="center"  class="panel-body">
						<img align="left" width="300" height="200" alt="${n.titulo}" src="<c:url value="/resources/images/${n.imagem}.png" />" />
								<div align="left">
									<h2 style="color: black;">${n.secao.titulo}</h2>
									<h2 style="color: black;">${n.titulo}</h2>
									<h3 style="color: black;">${n.subtitulo }</h3>
									${n.data }  -- 
									${n.usuario.nome} <br/><br/>
								</div>	
								
								</div> <!-- body panel -->
								<div class="panel-footer">
									<div id="textoNot" >
										${n.texto }
									</div>
								</div>
						</div>					
					</c:if>
				</c:forEach>
			</div>
	
</body>
</html>