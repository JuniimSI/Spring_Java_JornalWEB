<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Usuarios</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
		
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
</head>
<body>
	
		<c:forEach var="u" items="${usuarios}"> 
				<div class="panel panel-primary">
					<div align="center"  class="panel-body">
						<img align="left" width="100" height="60" alt="${u.nome}" src="<c:url value="/resources/images/${u.imagem}.png" />" /><br/>
						${u.nome } <br/>
						${u.email } <br/>
					</div> <!-- panel body -->
					<div class="panel-footer">
						${u.login } <br/> 
						
						<a href="apagarUsuario?id=${u.id }">Apagar</a>
					</div>
				</div>			
		</c:forEach>

</body>
</html>