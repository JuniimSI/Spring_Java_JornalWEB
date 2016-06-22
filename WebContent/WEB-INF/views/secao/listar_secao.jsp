<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Lista de seções</title>
</head>
<body>
	
		<c:forEach var="s" items="${secoes}">
			<div class="panel panel-primary">
						<a  class="btn btn-default" href="listarNoticia?secID=${s.id}"> ${s.titulo} </a> <br/>  
						<c:if test="${papelusuario.papelId  == 1}">
							<a href="alterarSecaoFormulario?id=${s.id }">Alterar</a> 
						</c:if>
			</div>
			
		</c:forEach>
	
</body>
</html>