<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Classificados</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
		
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
</head>
<body>
		<c:forEach var="c" items="${classificados}">
			
			
			<div class="panel panel-primary">
				<div align="center"  class="panel-body">
					${c.titulo } <br />
					
					Preco Inicial: ${c.preco } <br />
					Melhor Oferta: ${c.melhorOferta } <br />
					Update em: ${c.dataOferta }	 <br />
					
				</div>
				<div class="panel-footer">
					${c.texto } <br />
					${c.telefone } <br />
					<c:if test="${c.comprador != null }">
						Comprador atual: ${c.comprador} <br/>
					</c:if>
					
					<c:if test="${papelusuario.papelId  == 1 || (papelusuario.papelId  == 3 && papelusuario.usuarioId == usuario_logado.id)}">
						<%-- <a class="btn btn-default" href="alterarClassificadoFormulario?id=${c.id }"> Alterar </a> --%> 		
						<a class="btn btn-default" href="apagarClassificado?id=${c.id }"> Apagar </a> 		<br />
					</c:if>
					
					<c:if test="${papelusuario.papelId  == 3}">		
						
						<div id="ofertaValue">
							<form action="inserirOferta" method="post">
								<input type="hidden" name="usuarioId" value="${c.usuarioId}" />
								<input type="hidden" name="comprador" value="${usuario_logado.nome}" />
								<input type="hidden" name="id" value="${c.id}" /> 
							    <input type="hidden" name="titulo" value="${c.titulo }"/>   
								<input type="hidden" name="texto" value="${c.texto }"/> 
									<form:errors path="classificado.texto" /> 
								<input type="hidden" name="telefone" value="${c.telefone }"/>
								<input type="hidden" name="preco" value="${c.preco }"/> 
								
								<input placeholder="OFERTE!" type="text" name="melhorOferta" /> <br />
								<input id="oferta" class="btn" type="submit" value="Inserir Oferta"/>	
							</form>
						</div>	
					
					</c:if>	
				</div>
			</div>
		</c:forEach>

</body>
</html>