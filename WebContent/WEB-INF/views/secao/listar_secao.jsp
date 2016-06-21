<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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