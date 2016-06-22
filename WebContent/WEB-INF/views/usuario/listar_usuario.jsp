<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
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
						<img align="left" width="100" height="60"  src="<c:url value="/resources/images/${u.imagem}.png" />" /><br/>
						
						${u.nome } <br/>
						${u.email } <br/>
					</div> <!-- panel body -->
					<div class="panel-footer">
						${u.login } <br/> 
					</div>
				</div>			
		</c:forEach>

</body>
</html>