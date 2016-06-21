<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterando Papel</title>
</head>
<body>
	<c:if test="${papelusuario.papelId  != 1}">
			<script type="text/javascript">
				alert("Somente Editor pode Editar");
				location.href="realizarLoginFormulario";
			</script>
	</c:if>
	
	<h2>Alterando o Papel ${papel.nome }</h2>
	<form action="alterarPapel" method="post">
		<input type="hidden"  name="id" value="${papel.id}"/>
		Nome: <input type="text" name="nome" value="${papel.nome }"/>   <br />
			<form:errors path="papel.nome" />   <br />
		<input type="submit" value="Alterar Cadastro"/>
	</form>
	
	
</body>
</html>