<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Inserir Papel</title>
</head>
<body>

	<form action="inserirPapel" method="post">
		Nome: <input type="text" name="nome" />   <br />
			<form:errors path="papel.nome" />   <br />
		<input type="submit" value="EnviarCadastro"/>
	</form>


</body>
</html>